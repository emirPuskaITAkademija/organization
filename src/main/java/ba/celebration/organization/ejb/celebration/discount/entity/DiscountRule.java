package ba.celebration.organization.ejb.celebration.discount.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
//import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "discountRule")

@NamedQueries({
    @NamedQuery(name = "DiscountRule.findAll", query = "SELECT d FROM DiscountRule d"),
    @NamedQuery(name = "DiscountRule.findById", query = "SELECT d FROM DiscountRule d WHERE d.id = :id"),
    @NamedQuery(name = "DiscountRule.findBySpentOnCelebration", query = "SELECT d FROM DiscountRule d WHERE d.spentOnCelebration = :spentOnCelebration"),
    @NamedQuery(name = "DiscountRule.findBySpentOnCelebrationAndEarnedDiscount", query = "SELECT d FROM DiscountRule d WHERE d.spentOnCelebration = :spentOnCelebration AND d.earnedDiscount = :earnedDiscount"),
    @NamedQuery(name = "DiscountRule.findByEarnedDiscount", query = "SELECT d FROM DiscountRule d WHERE d.earnedDiscount = :earnedDiscount")})
public class DiscountRule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "spentOnCelebration")
    private BigDecimal spentOnCelebration;
    @Basic(optional = false)
    @NotNull
    @Min(value = 0, message = "Minimum discount is zero")
    @Max(value = 100, message = "Macimum discount is one hundred")
    @Column(name = "earnedDiscount")
    private BigDecimal earnedDiscount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", columnDefinition = "enum default ACTIVE")
    private String status;

    public DiscountRule() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getSpentOnCelebration() {
        return spentOnCelebration;
    }

    public void setSpentOnCelebration(BigDecimal spentOnCelebration) {
        this.spentOnCelebration = spentOnCelebration;
    }

    public BigDecimal getEarnedDiscount() {
        return earnedDiscount;
    }

    public void setEarnedDiscount(BigDecimal earnedDiscount) {
        this.earnedDiscount = earnedDiscount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiscountRule)) {
            return false;
        }
        DiscountRule other = (DiscountRule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.forspace.jakartademo.ejb.celebration.discount.entity.DiscountRule[ id=" + id + " ]";
    }
}
