package ba.celebration.organization.ejb.celebration.service;

import ba.celebration.organization.ejb.AbstractService;
import ba.celebration.organization.ejb.celebration.entity.Celebration;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CelebrationService extends AbstractService<Celebration> implements CelebrationServiceLocal {

    @PersistenceContext(unitName = "birthdayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CelebrationService() {
        super(Celebration.class);
    }

    @Override
    public void invalidateCache() {
        em.getEntityManagerFactory().getCache().evictAll();
    }
}

