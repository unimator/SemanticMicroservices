package pl.agh.edu.SemanticMicroservice.Managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.agh.edu.SemanticMicroservice.Model.ServiceDefinition;
import pl.agh.edu.SemanticMicroservice.Repositories.IServicesRepository;

import java.util.UUID;

@Service
public class ServicesRegistryManager implements IServicesRegistryManager {

    private IServicesRepository servicesRepository;

    @Autowired
    public ServicesRegistryManager(IServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Override
    public boolean registerService(ServiceDefinition serviceDefinition) {
        try {
            servicesRepository.addService(serviceDefinition);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deregisterService(UUID serviceIdentifier) {
        try {
            servicesRepository.removeService(serviceIdentifier);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }
}
