import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Quiz {
    public  int score=0;
    public List<QuizQuestion> getQuestions(Connection connection) throws SQLException{
        List<QuizQuestion> questions = new ArrayList<>();
        String query = "SELECT * FROM question";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()){
            String questionText = rs.getString("questionName");
            List<String> options = new ArrayList<>();

            options.add(rs.getString("option1"));
            options.add(rs.getString("option2"));
            options.add(rs.getString("option3"));
            options.add(rs.getString("correctAns"));
            Collections.shuffle(options);


            String correctAns = rs.getString("correctAns");
            QuizQuestion question = new QuizQuestion(questionText, options, correctAns);
            questions.add(question);

        }
        return questions;
    }

    public void displayQuestion(QuizQuestion question){
        System.out.println(question.getQuestionName());
        List<String> options = question.getOptions();

        for (int i = 0; i < options.size(); i++){
            System.out.println((i+1) + "." + options.get(i));
        }

    }

    public  String getUserAns(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your answer: ");
        return scanner.nextLine();
    }

    public void checkAns(QuizQuestion question, String userAns){
        if (userAns.equals(question.getCorrectAns())){
            System.out.println("Correct");
            score++;

        } else {
            System.out.println("Sorry. The correct answer is " + question.getCorrectAns() );
        }
    }



}
