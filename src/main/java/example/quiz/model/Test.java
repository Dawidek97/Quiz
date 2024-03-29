package example.quiz.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    // nazwa klucza obcego po drugiej stronie
    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    List<Question> questionList = new ArrayList<>();
    private String name;

    public Test(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Test() {
    }

    public void addQuestion(Question question){
        question.setTest(this);
        questionList.add(question);
    }
}
