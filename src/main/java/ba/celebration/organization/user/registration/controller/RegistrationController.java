package ba.celebration.organization.user.registration.controller;


import ba.celebration.organization.ejb.user.service.UserServiceLocal;
import ba.celebration.organization.user.registration.model.RegistrationModel;
import ba.celebration.organization.ejb.user.entity.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrationController {

    private final UserServiceLocal userFacadeLocal;
    private final RegistrationModel registrationModel;

    public boolean usernameOccupied() {
        User user = userFacadeLocal.findByUsername(registrationModel.getUsername());
        return user != null;
    }

    public boolean isValidRegistrationModel() {
        return !registrationModel.getName().isEmpty()
                && !registrationModel.getSurname().isEmpty()
                && !registrationModel.getUsername().isEmpty()
                && !registrationModel.getPlainPassword().isEmpty()
                && !registrationModel.getEmail().isEmpty()
                && !registrationModel.getTown().isEmpty()
                && !registrationModel.getContact().isEmpty();
    }

}