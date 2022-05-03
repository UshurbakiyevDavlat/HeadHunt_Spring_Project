package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.JMS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecieverTest {
    Reciever reciever = new Reciever();

    @Test
    void testReceiveMessage() {
        String result = reciever.receiveMessage("text");
        Assertions.assertEquals("text", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme