package ba.celebration.organization.ejb.service.type.service;

import ba.celebration.organization.ejb.service.type.entity.ServiceType;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ServiceTypeServiceLocal {

    void create(ServiceType serviceType);

    void edit(ServiceType serviceType);

    void remove(ServiceType serviceType);

    ServiceType find(Object id);

    ServiceType findByName(String name);

    List<ServiceType> findAll();

    List<ServiceType> findRange(int[] range);

    int count();

}
