package ba.celebration.organization.ejb.service.type.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import ba.celebration.organization.ejb.celebration.cost.entity.CelebrationCost;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//import jakarta.xml.bind.annotation.XmlRootElement;
//import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "serviceType")

@NamedQueries({
    @NamedQuery(name = "ServiceType.findAll", query = "SELECT s FROM ServiceType s"),
    @NamedQuery(name = "ServiceType.findById", query = "SELECT s FROM ServiceType s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceType.findByName", query = "SELECT s FROM ServiceType s WHERE s.name = :name"),
    @NamedQuery(name = "ServiceType.findByCostPerUnit", query = "SELECT s FROM ServiceType s WHERE s.costPerUnit = :costPerUnit"),
    @NamedQuery(name = "ServiceType.findByDescription", query = "SELECT s FROM ServiceType s WHERE s.description = :description"),
    @NamedQuery(name = "ServiceType.findByStatus", query = "SELECT s FROM ServiceType s WHERE s.status = :status")})
public class ServiceType implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "costPerUnit")
    private BigDecimal costPerUnit;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceType")
    private List<CelebrationCost> celebrationCostList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    public static final String ACTIVE = "ACTIVE";
    public static final String DEACTIVATED = "DEACTIVATED";

    public ServiceType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @XmlTransient
    public List<CelebrationCost> getCelebrationCostList() {
        return celebrationCostList;
    }

    public void setCelebrationCostList(List<CelebrationCost> celebrationCostList) {
        this.celebrationCostList = celebrationCostList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(BigDecimal costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof ServiceType)) {
            return false;
        }
        ServiceType other = (ServiceType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + "[" + id + "]";
    }
}
