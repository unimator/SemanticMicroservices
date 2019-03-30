package pl.agh.edu.SemanticMicroservice.Repositories;

import pl.agh.edu.SemanticMicroservice.Model.ServiceDefinition;

import java.util.UUID;

public interface IServicesRepository {
    void addService(ServiceDefinition serviceDefinition) throws IllegalArgumentException;

    void removeService(UUID serviceIdentifier) throws IllegalArgumentException;
}
