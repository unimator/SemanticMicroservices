package pl.agh.edu.SemanticMicroservice.Repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.agh.edu.SemanticMicroservice.Model.ServiceDefinition;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Profile("test")
@Service
public class InMemoryServicesRepository implements IServicesRepository {
    private List<ServiceDefinition> services;

    public InMemoryServicesRepository() {
        services = new LinkedList<ServiceDefinition>();
    }

    @Override
    public void addService(ServiceDefinition serviceDefinition) throws IllegalArgumentException  {
        if(services.stream().anyMatch(service -> service.getIdentifier().equals(serviceDefinition.getIdentifier()))) {
            throw new IllegalArgumentException(String.format("Trying to add duplicated service (UUID = %s", serviceDefinition.getIdentifier()));
        }

        services.add(serviceDefinition);
    }

    @Override
    public void removeService(UUID serviceIdentifier) throws IllegalArgumentException {
        if(services.stream().noneMatch(service -> service.getIdentifier().equals(serviceIdentifier))) {
            throw new IllegalArgumentException(String.format("Trying to remove not registered service (UUID = %s", serviceIdentifier));
        }

        services.removeIf(service -> service.getIdentifier().equals(serviceIdentifier));
    }

    public Iterator<ServiceDefinition> getRegisteredServices() {
        return services.iterator();
    }
}
