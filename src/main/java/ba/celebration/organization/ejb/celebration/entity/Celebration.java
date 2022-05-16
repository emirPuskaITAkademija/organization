package ba.celebration.organization.ejb.celebration.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import ba.celebration.organization.ejb.celebration.cost.entity.CelebrationCost;
import ba.celebration.organization.ejb.user.entity.User;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
//import jakarta.xml.bind.annotation.XmlRootElement;
//import jakarta.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "celebration")

@NamedQueries({
    @NamedQuery(name = "Celebration.findAll", query = "SELECT c FROM Celebration c"),
    @NamedQuery(name = "Celebration.findById", query = "SELECT c FROM Celebration c WHERE c.id = :id"),
    @NamedQuery(name = "Celebration.findByName", query = "SELECT c FROM Celebration c WHERE c.name = :name"),
    @NamedQuery(name = "Celebration.findByCelebrationDate", query = "SELECT c FROM Celebration c WHERE c.celebrationDate = :celebrationDate"),
    @NamedQuery(name = "Celebration.findByUserCreator", query = "SELECT c FROM Celebration c WHERE c.userCreator = :userCreator")})
public class Celebration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "celebrationDate")
    @Temporal(TemporalType.DATE)
    private Date celebrationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "celebration")
    private List<CelebrationCost> celebrationCostList;

    @JoinColumn(name = "user_creator", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userCreator;

    public Celebration() {
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

    public User getUserCreator() {
        return userCreator;
    }

    public void setUserCreator(User userCreator) {
        this.userCreator = userCreator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCelebrationDate() {
        return celebrationDate;
    }

    public void setCelebrationDate(Date celebrationDate) {
        this.celebrationDate = celebrationDate;
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
        if (!(object instanceof Celebration)) {
            return false;
        }
        Celebration other = (Celebration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + " [" + id + " ]";
    }

}
