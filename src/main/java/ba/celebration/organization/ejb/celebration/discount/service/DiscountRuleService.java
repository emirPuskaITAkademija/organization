package ba.celebration.organization.ejb.celebration.discount.service;

import ba.celebration.organization.ejb.AbstractService;
import ba.celebration.organization.ejb.celebration.discount.entity.DiscountRule;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.util.logging.Logger;

@Stateless
public class DiscountRuleService extends AbstractService<DiscountRule> implements DiscountRuleServiceLocal {

    @PersistenceContext(unitName = "birthdayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscountRuleService() {
        super(DiscountRule.class);
    }

    @Override
    public DiscountRule findyBySpentOnCelebrationAndEarnedDiscount(BigDecimal spentOnCelebration, BigDecimal earnedDiscount) {
        DiscountRule discountRule = null;
        try{
            Query query = em.createNamedQuery("DiscountRule.findBySpentOnCelebrationAndEarnedDiscount");
            query.setParameter("spentOnCelebration", spentOnCelebration);
            query.setParameter("earnedDiscount", earnedDiscount);
            discountRule = (DiscountRule)query.getSingleResult();
        }catch(NonUniqueResultException | NoResultException e){
            Logger.getLogger(getClass().getName()).info(e.getMessage());
        }
        return discountRule;
    }


}