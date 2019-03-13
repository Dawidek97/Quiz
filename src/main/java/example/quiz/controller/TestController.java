package example.quiz.controller;

import example.quiz.model.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Scope(value = "session") // dzieki temu kazdy uzytkownik bedzie mial swoj kontroller
@Controller
public class TestController {

    User user = new User();
    private int counter;
    @ResponseBody
    @GetMapping("/test/{id}/play")
    public String play(@PathVariable Integer id){
        user.addPoint();
        return "" + user.getNumberOfPoints();
    }
}
