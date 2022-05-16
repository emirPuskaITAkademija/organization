package ba.celebration.organization.ejb.celebration.discount.service;

import ba.celebration.organization.ejb.celebration.discount.entity.DiscountRule;
import jakarta.ejb.Local;

import java.math.BigDecimal;
import java.util.List;

@Local
public interface DiscountRuleServiceLocal {

    void create(DiscountRule discountRule);

    void edit(DiscountRule discountRule);

    void remove(DiscountRule discountRule);

    DiscountRule find(Object id);

    List<DiscountRule> findAll();

    List<DiscountRule> findRange(int[] range);

    int count();

    DiscountRule findyBySpentOnCelebrationAndEarnedDiscount(BigDecimal spentOnCelebration, BigDecimal earnedDiscount);
}
