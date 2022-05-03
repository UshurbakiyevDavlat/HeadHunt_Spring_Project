package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Security;

import org.springframework.security.core.GrantedAuthority;


public class SimpleGrantedAuthority implements GrantedAuthority {


    private final String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
