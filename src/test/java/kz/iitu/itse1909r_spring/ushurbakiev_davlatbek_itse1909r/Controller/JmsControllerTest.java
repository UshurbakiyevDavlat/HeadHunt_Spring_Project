package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Controller;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Controller.JmsController;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.JMS.Action;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.JMS.Reciever;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.logging.Logger;

import static org.mockito.Mockito.*;

class JmsControllerTest {
    @Mock
    Action action;

    @Mock
    Reciever reciever;

    @Mock
    Logger log;
    @InjectMocks
    JmsController jmsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSend() throws SQLException {
        when(action.SendMessage()).thenReturn(true);

        ResponseEntity<String> result = jmsController.send();
        Assertions.assertEquals("<200 OK OK,[]>", result.toString());
    }

    @Test
    void testListen() throws SQLException {
        when (reciever.receiveMessage("text")).thenReturn("ok!");

        ResponseEntity<String> result = jmsController.listen();
        Assertions.assertEquals("<200 OK OK,[]>", result.toString());

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme