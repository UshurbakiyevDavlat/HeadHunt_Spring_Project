package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Security;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.*;

class AuthenticationSuccessEventListenerTest {
    @Mock
    HttpServletRequest request;
    @Mock
    LoginAttemptService loginAttemptService;
    @InjectMocks
    AuthenticationSuccessEventListener authenticationSuccessEventListener;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testOnApplicationEvent() {
        authenticationSuccessEventListener.onApplicationEvent(null);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme