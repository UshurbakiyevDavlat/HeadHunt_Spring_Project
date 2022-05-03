package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Security;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Map;

public class OrganizationSubClaimAdapter implements
        Converter<Map<String, Object>, Map<String, Object>> {

//    private final MappedJwtClaimSetConverter delegate =
//            MappedJwtClaimSetConverter.withDefaults(Collections.emptyMap());

    public Map<String, Object> convert(Map<String, Object> claims) {
//        Map<String, Object> convertedClaims = this.delegate.convert(claims);
//        String organization = convertedClaims.get("organization") != null ?
//                (String) convertedClaims.get("organization") : "unknown";
//
//        convertedClaims.put("organization", organization.toUpperCase());
//
//        return convertedClaims;
        return  null;
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }

    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }

//    @Bean
//    public JwtDecoder customDecoder(OAuth2ResourceServerProperties properties) {
//        NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(
//                properties.getJwt().getJwkSetUri()).build();
//
//        jwtDecoder.setClaimSetConverter(new OrganizationSubClaimAdapter());
//        return jwtDecoder;
//    }

}
