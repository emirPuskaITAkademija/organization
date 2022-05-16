package ba.celebration.organization.ejb.user.service;



import java.util.List;

import ba.celebration.organization.user.authentication.model.AuthenticationModel;
import ba.celebration.organization.user.registration.model.RegistrationModel;
import ba.celebration.organization.ejb.user.entity.User;
import jakarta.ejb.Local;

// 2 session bean EJB -> local i remote
@Local
public interface UserServiceLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();

    User findByUsername(String username);

    User register(RegistrationModel registerModel);

    User login(AuthenticationModel authenticationModel);

   User update(RegistrationModel registrationModel);
}