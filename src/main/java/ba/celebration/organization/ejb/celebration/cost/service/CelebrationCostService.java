package ba.celebration.organization.ejb.celebration.cost.service;

import ba.celebration.organization.ejb.AbstractService;
import ba.celebration.organization.ejb.celebration.cost.entity.CelebrationCost;
import ba.celebration.organization.ejb.celebration.entity.Celebration;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CelebrationCostService extends AbstractService<CelebrationCost> implements CelebrationCostServiceLocal {

    @PersistenceContext(unitName = "birthdayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CelebrationCostService() {
        super(CelebrationCost.class);
    }

    @Override
    public List<CelebrationCost> findByCelebration(Celebration celebration) {
        try{
            Query query = em.createNamedQuery("CelebrationCost.findByCelebration");
            query.setParameter("celebration", celebration);
            return query.getResultList();
        }catch(NoResultException e){
            Logger.getLogger(getClass().getName()).info(e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }
}