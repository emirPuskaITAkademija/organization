package ba.celebration.organization.ejb.user.privilege.service;

import ba.celebration.organization.ejb.AbstractService;
import ba.celebration.organization.ejb.user.privilege.entity.Privilege;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PrivilegeService extends AbstractService<Privilege> implements PrivilegeServiceLocal {
    @PersistenceContext(name = "birthdayPU")
    private EntityManager entityManager;

    public PrivilegeService() {
        super(Privilege.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
