package ba.celebration.organization.ejb.town.service;

import ba.celebration.organization.ejb.town.entity.Town;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface TownServiceLocal {

    void create(Town town);

    void edit(Town town);

    void remove(Town town);

    Town find(Object id);

    List<Town> findAll();

    List<Town> findRange(int[] range);

    int count();
}
