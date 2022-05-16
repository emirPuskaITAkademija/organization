package ba.celebration.organization.ejb.celebration.model;

import ba.celebration.organization.ejb.user.entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CelebrationModel {

    private String name;
    private Date celebrationDate;
    private User userCreator;
}