package ba.celebration.organization.ejb.celebration.service;

import ba.celebration.organization.ejb.celebration.entity.Celebration;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CelebrationServiceLocal {

    void create(Celebration celebration);

    void edit(Celebration celebration);

    void remove(Celebration celebration);

    Celebration find(Object id);

    List<Celebration> findAll();

    List<Celebration> findRange(int[] range);

    int count();

    void invalidateCache();

}