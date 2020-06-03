package com.example.gcloudiapdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Data
@Entity(name = "externalConfig")
@AllArgsConstructor
public class ExternalConfig {
    @Id
    Long id;

    String variableKey;

    String variableValue;
}
