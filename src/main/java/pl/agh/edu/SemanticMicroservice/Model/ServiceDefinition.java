package pl.agh.edu.SemanticMicroservice.Model;

import java.util.Map;
import java.util.UUID;

public class ServiceDefinition {

    private String name;
    private UUID identifier;
    private Map<String, Float> keywords;

    public ServiceDefinition() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public Map<String, Float> getKeywords() {
        return keywords;
    }

    public void setKeywords(Map<String, Float> keywords) {
        this.keywords = keywords;
    }
}
