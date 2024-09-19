package com.medilabo.diagnosis_view.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Intercepteur de toutes les requetes http entrantes et sortantes du
 * microservice. Utilisé pour ajouter et vérifier le passage par OpenFeign
 * du token Authorization.
 */
@Component
public class ForwardedAuthHeaderInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (requestAttributes != null) {
            String authorizationHeader =
                    requestAttributes.getRequest().getHeader("Authorization");
            if (authorizationHeader != null) {
                System.out.println("Authorization token found in incoming request.");

                requestTemplate.header("Authorization", authorizationHeader);
            } else {
                System.out.println("No authorization token found in incoming request");
            }
        }
    }

}
