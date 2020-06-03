package com.example.gcloudiapdemo.controller;

import com.example.gcloudiapdemo.model.ExternalConfig;
import com.example.gcloudiapdemo.service.ExternalConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ExternalConfigController {
    @Autowired
    ExternalConfigService service;

    @GetMapping
    public Iterable<ExternalConfig> getAllConfig() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            return service.getAllConfig();
        }
        else {
            return null;
        }
    }

    @GetMapping("/{variableKey}")
    public ExternalConfig getConfigByKey(@PathVariable String variableKey) {
        return service.getConfigByKey(variableKey);
    }

    @PostMapping
    public ExternalConfig createConfig(@RequestBody ExternalConfig config) {
        return service.createConfig(config);
    }

    @PutMapping("/{variableKey}")
    public ExternalConfig updateConfig(@PathVariable String variableKey,
                                       @RequestBody ExternalConfig config) {
        return service.updateConfig(variableKey, config);
    }

    @DeleteMapping("/{variableKey}")
    public void deleteConfig(@PathVariable String variableKey) {
        service.deleteConfig(variableKey);
    }
}