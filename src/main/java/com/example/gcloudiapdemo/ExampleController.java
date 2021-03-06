package com.example.gcloudiapdemo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("admin")
public class ExampleController {


    @RequestMapping("/")
    public String unsecured() {
        return "No secrets here!\n";
    }

    @RequestMapping("/topsecret")
    public String secured() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Jwt) {
            Jwt jwt = (Jwt) authentication.getPrincipal();
            return String.format("You are [%s] with e-mail address [%s].%n",
                    jwt.getSubject(), jwt.getClaimAsString("email"));
        }
        else {
            return "Something went wrong; authentication is not provided by IAP/JWT.\n";
        }

    }
}
