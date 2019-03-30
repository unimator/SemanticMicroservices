package pl.agh.edu.SemanticMicroservice.Managers;


import pl.agh.edu.SemanticMicroservice.Model.ServiceDefinition;

import java.util.UUID;

public interface IServicesRegistryManager {
    boolean registerService(ServiceDefinition serviceDefinition);

    boolean deregisterService(UUID serviceIdentifier);
}
