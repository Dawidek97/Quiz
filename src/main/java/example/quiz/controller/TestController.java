package example.quiz.controller;

import example.quiz.model.Test;
import example.quiz.model.User;
import example.quiz.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Scope(value = "session") // dzieki temu kazdy uzytkownik bedzie mial swoj kontroller
@Controller
public class TestController {

    @Autowired
    private TestRepository testRepository;

    private User user = new User();

    @GetMapping("/test/{id}/play")
    public String play(@PathVariable Integer id, ModelMap modelMap){
        Test test = testRepository.findById(id).get();
        modelMap.addAttribute("test", test);
        modelMap.addAttribute("question", test.getQuestionList().get(0));
        return "test";
    }
}