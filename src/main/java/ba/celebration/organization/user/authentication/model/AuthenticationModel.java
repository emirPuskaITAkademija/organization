package ba.celebration.organization.user.authentication.model;

import lombok.Data;

@Data
public class AuthenticationModel {

    private String username;
    private String plainPassword;
}
