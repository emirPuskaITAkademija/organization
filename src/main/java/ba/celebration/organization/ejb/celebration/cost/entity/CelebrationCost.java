package ba.celebration.organization.ejb.celebration.cost.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import ba.celebration.organization.ejb.service.type.entity.ServiceType;
import ba.celebration.organization.ejb.celebration.entity.Celebration;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
//import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "celebrationCost")

@NamedQueries({
    @NamedQuery(name = "CelebrationCost.findAll", query = "SELECT c FROM CelebrationCost c"),
    @NamedQuery(name = "CelebrationCost.findById", query = "SELECT c FROM CelebrationCost c WHERE c.id = :id"),
    @NamedQuery(name = "CelebrationCost.findByCelebration", query = "SELECT c FROM CelebrationCost c WHERE c.celebration = :celebration"),
    @NamedQuery(name = "CelebrationCost.findByServiceType", query = "SELECT c FROM CelebrationCost c WHERE c.serviceType = :serviceType"),
    @NamedQuery(name = "CelebrationCost.findByQuantity", query = "SELECT c FROM CelebrationCost c WHERE c.quantity = :quantity")})
public class CelebrationCost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @JoinColumn(name = "celebration_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Celebration celebration;
    @JoinColumn(name = "service_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ServiceType serviceType;

    public CelebrationCost() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Celebration getCelebration() {
        return celebration;
    }

    public void setCelebration(Celebration celebration) {
        this.celebration = celebration;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
        if (!(object instanceof CelebrationCost)) {
            return false;
        }
        CelebrationCost other = (CelebrationCost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.forspace.jakartademo.ejb.celebration.cost.entity.CelebrationCost[ id=" + id + " ]";
    }

}
