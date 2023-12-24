import java.sql.Connection;
import java.util.List;

public class QuizQuestion {

    private String questionName;
    private List<String> options;
    private String correctAns;

    public QuizQuestion(String questionName, List<String> options, String correctAns){
        this.questionName = questionName;
        this.options = options;
        this.correctAns = correctAns;
    }
    public String getQuestionName() {
        return questionName;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAns() {
        return correctAns;
    }
}
