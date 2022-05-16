package ba.celebration.organization.ejb.celebration.cost.service;

import ba.celebration.organization.ejb.celebration.cost.entity.CelebrationCost;
import ba.celebration.organization.ejb.celebration.entity.Celebration;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CelebrationCostServiceLocal {

    void create(CelebrationCost celebrationCost);

    void edit(CelebrationCost celebrationCost);

    void remove(CelebrationCost celebrationCost);

    CelebrationCost find(Object id);

    List<CelebrationCost> findAll();

    List<CelebrationCost> findRange(int[] range);

    int count();

    public List<CelebrationCost> findByCelebration(Celebration celebration);
}