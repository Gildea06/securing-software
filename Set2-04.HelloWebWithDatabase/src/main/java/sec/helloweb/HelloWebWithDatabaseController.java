package sec.helloweb;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWebWithDatabaseController {

    @Autowired
    private HelloMessageRepository helloMessageRepository;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        List<HelloMessage> messages = helloMessageRepository.findAll();
        if (messages.size() > 0) {
            HelloMessage message = messages.get(0);
            helloMessageRepository.delete(message);
            return message.getContent();
        }
        return "Hello Web!";
    }
}
