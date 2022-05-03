//package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.JMS;
//
//import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
//import org.springframework.jms.annotation.EnableJms;
//import org.springframework.jms.core.JmsTemplate;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.TextMessage;
//import java.util.Map;
//
//
//@EnableJms
//public class Listener implements MessageListener {
//
//    public JmsTemplate getJmsTemplate() {
//        return getJmsTemplate();
//    }
//
//    public void onMessage(Message message) {
//        if (message instanceof TextMessage) {
//            try {
//                String msg = ((TextMessage) message).getText();
//                System.out.println("Message has been consumed : " + msg);
//            } catch (JMSException ex) {
//                throw new RuntimeException(ex);
//            }
//        } else {
//            throw new IllegalArgumentException("Message Error");
//        }
//    }
//
//    public Candidates receiveMessage() throws JMSException {
//        Map map = (Map) getJmsTemplate().receiveAndConvert();
//        return new Candidates((String) map.get("name"), (Integer) map.get("age"));
//    }
//}
