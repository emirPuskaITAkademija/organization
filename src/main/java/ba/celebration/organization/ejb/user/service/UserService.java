package ba.celebration.organization.ejb.user.service;

import ba.celebration.organization.user.authentication.model.AuthenticationModel;
import ba.celebration.organization.user.registration.model.RegistrationModel;
import ba.celebration.organization.ejb.AbstractService;
import ba.celebration.organization.ejb.town.entity.Town;
import ba.celebration.organization.ejb.town.service.TownServiceLocal;
import ba.celebration.organization.ejb.user.entity.User;
import ba.celebration.organization.ejb.user.privilege.entity.Privilege;
import ba.celebration.organization.ejb.user.privilege.service.PrivilegeServiceLocal;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.util.logging.Logger;

@Stateless
public class UserService extends AbstractService<User> implements UserServiceLocal {

    @PersistenceContext(unitName = "birthdayPU")
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash;

    @Inject
    private TownServiceLocal townFacadeLocal;

    @Inject
    private PrivilegeServiceLocal privilegeFacadeLocal;

    public UserService() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public User register(RegistrationModel registerModel) {

        User user = findByUsername(registerModel.getUsername());
        if (user == null) {
            user = new User();
            user.setName(registerModel.getName());
            user.setSurname(registerModel.getSurname());
            user.setUsername(registerModel.getUsername());
            String hashedPassword = pbkdf2PasswordHash.generate(registerModel.getPlainPassword().toCharArray());
            user.setPassword(hashedPassword);
            Town selectedTown = townFacadeLocal.find(registerModel.getTownId());
            user.setTown(selectedTown);
            user.setEmail(registerModel.getEmail());
            user.setContact(registerModel.getContact());
            Privilege privilege = privilegeFacadeLocal.find(Privilege.CLIENT_PRIVILEGE);
            user.setPrivilege(privilege);
            user.setStatus("active");
            create(user);
        }
        return user;
    }

    @Override
    public User update(RegistrationModel registerModel) {
        User user = findByUsername(registerModel.getUsername());
        if (user != null) {
            user.setName(registerModel.getName());
            user.setSurname(registerModel.getSurname());
            Town selectedTown = townFacadeLocal.find(registerModel.getTownId());
            user.setTown(selectedTown);
            user.setEmail(registerModel.getEmail());
            user.setContact(registerModel.getContact());
            String hashPass = pbkdf2PasswordHash.generate(registerModel.getPlainPassword().toCharArray());
            user.setPassword(hashPass);
            edit(user);
        }
        return user;
    }


    @Override
    public User login(AuthenticationModel authenticationModel) {
        User user = null;
        try {
            Query query = entityManager.createNamedQuery("User.findByUsername");
            query.setParameter("username", authenticationModel.getUsername());
            user = (User) query.getSingleResult();
            if(!pbkdf2PasswordHash.verify(authenticationModel.getPlainPassword().toCharArray(), user.getPassword())){
                throw new NoResultException("Wrong password");
            }
        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Not exist or not unique: " + e.getMessage());
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            Query query = entityManager.createNamedQuery("User.findByUsername");
            query.setParameter("username", username);
            user = (User) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Not exist or not unique: " + e.getMessage());
        }
        return user;
    }
}
