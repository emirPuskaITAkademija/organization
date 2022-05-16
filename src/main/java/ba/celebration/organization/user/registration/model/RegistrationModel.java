package ba.celebration.organization.user.registration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationModel {

    private String name;
    private String surname;
    private String username;
    private String plainPassword;
    private String email;
    private String contact;
    private String town;

    public Integer getTownId() {
        if (town.contains("[")) {
            String townIdText = town.substring(town.indexOf("[") + 1, town.indexOf("]"));
            return Integer.parseInt(townIdText);
        } else {
            return Integer.parseInt(town);
        }
    }
}
