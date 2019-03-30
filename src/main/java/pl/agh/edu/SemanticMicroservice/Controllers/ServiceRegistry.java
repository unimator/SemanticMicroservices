package pl.agh.edu.SemanticMicroservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.agh.edu.SemanticMicroservice.Managers.IServicesRegistryManager;
import pl.agh.edu.SemanticMicroservice.Model.ServiceDefinition;

import java.util.UUID;

@Controller
@RequestMapping("/register")
public class ServiceRegistry {

    private final IServicesRegistryManager serviceRegistryManager;

    @Autowired
    public ServiceRegistry(IServicesRegistryManager serviceRegistryManager) {
        this.serviceRegistryManager = serviceRegistryManager;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean Register(@RequestBody ServiceDefinition serviceDefinition) {
        return serviceRegistryManager.registerService(serviceDefinition);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean Deregister(@RequestParam UUID serviceIdentifier){
        return serviceRegistryManager.deregisterService(serviceIdentifier);
    }
}
