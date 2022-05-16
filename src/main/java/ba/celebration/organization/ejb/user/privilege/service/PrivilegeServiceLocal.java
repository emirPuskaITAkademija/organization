package ba.celebration.organization.ejb.user.privilege.service;

import ba.celebration.organization.ejb.user.privilege.entity.Privilege;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface PrivilegeServiceLocal {
    void create(Privilege privilege);

    void edit(Privilege privilege);

    void remove(Privilege privilege);

    Privilege find(Object id);

    List<Privilege> findAll();

    List<Privilege> findRange(int[] range);

    int count();
}
