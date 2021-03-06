package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.JMS;

import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@EnableJms
@Component
public class Reciever {

    @JmsListener(destination = "Listener")
    public String receiveMessage(String text) {
        System.out.println("Received <" + text + ">");
        return text;
    }
}
