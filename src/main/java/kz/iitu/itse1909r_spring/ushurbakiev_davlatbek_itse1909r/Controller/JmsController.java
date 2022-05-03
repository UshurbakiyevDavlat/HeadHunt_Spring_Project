package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Controller;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.JMS.Action;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.JMS.Reciever;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/jms")
@Log
public class JmsController {
    private final Action action;
    private final Reciever reciever;

    @Autowired
    public JmsController(
            Action action
            , Reciever reciever
    ) {
        this.action = action;
        this.reciever = reciever;
    }

    @GetMapping("/listen")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> listen() throws SQLException {
        log.info(reciever.receiveMessage("text"));
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> send() throws SQLException {
        try {
            action.SendMessage();
//            reciever.receiveMessage("text");
        } catch (Exception exception) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
