package com.example.gcloudiapdemo.repository;

import com.example.gcloudiapdemo.model.ExternalConfig;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface ExternalConfigRepository extends DatastoreRepository<ExternalConfig, Long> {
    ExternalConfig findByVariableKey(String key);
}
