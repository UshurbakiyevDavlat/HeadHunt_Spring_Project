package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Web;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Security.DetailService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Service.CandidateService;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Candidates;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.Message;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.database.OutputMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Request;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Slf4j
public class WebController {

    @Autowired
    DetailService detailService;
    @Autowired
    CandidateService candidateService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String testing(Model model) {
        model.addAttribute("serverTime", new Date());
        return "index";
    }


    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public String auth(@ModelAttribute Candidates candidates, Model model) {
        return "success";
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

    @GetMapping("/saveUser")
    public String save() {
        return "register";
    }

    @PostMapping("/register")
    public String save(@RequestBody MultiValueMap<String, String> formData) throws SQLException {


        String pass = formData.getFirst("password");
        String account_name = formData.getFirst("account_name");
        String email = formData.getFirst("email");

        log.info(formData.toString());

        candidateService.create(new Candidates(account_name, pass,email));
        return "index";
    }

    @GetMapping("/chating")
    public String chat() {
        return "message";
    }

    @GetMapping("/403")
    public String error403() {
        return "/403";
    }
}
