package example.quiz.data;

import example.quiz.model.Question;
import example.quiz.model.Test;
import example.quiz.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // sprawia ze klasa bedzie zarzadzana przez kontener springa
public class SpringExampleData implements CommandLineRunner {

    @Autowired
    private TestRepository testRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello");

        Test test = new Test("Test wiedzy z Javy");
        test.addQuestion(new Question("Czy java ma klasy ?", true));
        test.addQuestion(new Question("Czy java ma intejfejsy ?", true));
        test.addQuestion(new Question("Czy java ma klase Integer ?", false));
        test.addQuestion(new Question("Czy java ma destruktor ?", false));

        Test test2 = new Test("Test jazdy na rowerze");
        test2.addQuestion(new Question("czy rower ma pedały ?", true));
        test2.addQuestion(new Question("czy rower ma silnik ?", false));
        test2.addQuestion(new Question("czy w rorzewe jest łańcuch ?", true));
        test2.addQuestion(new Question("czy w rowerze możemy jechać do tyłu?", true));
        test2.addQuestion(new Question("czy w rowerem możemy latać ?", false));

        testRepository.save(test);
        testRepository.save(test2);
    }
}
