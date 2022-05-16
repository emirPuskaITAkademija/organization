package ba.celebration.organization.ejb.town.service;

import ba.celebration.organization.ejb.AbstractService;
import ba.celebration.organization.ejb.town.entity.Town;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
public class TownService extends AbstractService<Town> implements TownServiceLocal {
    @PersistenceContext(unitName = "birthdayPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TownService() {
        super(Town.class);
    }

    @Override
    public List<Town> findAll() {
        Query query = em.createNamedQuery("Town.findAll");
        List<Town> towns = query.getResultList();
        return towns;
    }
}
