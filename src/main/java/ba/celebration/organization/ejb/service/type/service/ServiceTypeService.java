package ba.celebration.organization.ejb.service.type.service;

import ba.celebration.organization.ejb.AbstractService;
import ba.celebration.organization.ejb.service.type.entity.ServiceType;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.logging.Logger;

@Stateless
public class ServiceTypeService extends AbstractService<ServiceType> implements ServiceTypeServiceLocal {

    @PersistenceContext(unitName = "birthdayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceTypeService() {
        super(ServiceType.class);
    }

    @Override
    public ServiceType findByName(String name) {
        ServiceType serviceType=null;
        try {
            Query query = em.createNamedQuery("ServiceType.findByName");
            query.setParameter("name", name);
            serviceType = (ServiceType) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).info(e.getMessage());
        }
        return serviceType;
    }
}