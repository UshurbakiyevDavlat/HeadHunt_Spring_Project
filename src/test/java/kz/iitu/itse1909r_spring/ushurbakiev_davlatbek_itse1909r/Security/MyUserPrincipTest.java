package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;

class MyUserPrincipTest {
    //Field user of type Optional - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    MyUserPrincip myUserPrincip = new MyUserPrincip();

    @Test
    void testGetAuthorities() {
       org.springframework.security.core.authority.SimpleGrantedAuthority authority = new SimpleGrantedAuthority("Admin");
        List<GrantedAuthority> grantedAuthorities = List.of(authority);


        Collection<? extends GrantedAuthority> result = myUserPrincip.getAuthorities();
        Assertions.assertNull(result);   }

//    @Test
//    void testGetPassword() {
//        when(myUserPrincip.getPassword()).thenReturn("dada2000");
//        String result = myUserPrincip.getPassword();
//        Assertions.assertEquals("dada2000", result);
//    }
//
//    @Test
//    void testGetUsername() {
//        when(myUserPrincip.getUsername()).thenReturn("Davlat");
//        String result = myUserPrincip.getUsername();
//        Assertions.assertEquals("Davlat",result);
//    }

    @Test
    void testIsAccountNonExpired() {
        boolean result = myUserPrincip.isAccountNonExpired();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testIsAccountNonLocked() {
        boolean result = myUserPrincip.isAccountNonLocked();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testIsCredentialsNonExpired() {
        boolean result = myUserPrincip.isCredentialsNonExpired();
        Assertions.assertEquals(true, result);
    }

    @Test
    void testIsEnabled() {
        boolean result = myUserPrincip.isEnabled();
        Assertions.assertEquals(true, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme