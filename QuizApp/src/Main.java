import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* Make sure to import the mysql-connector-java 5.1.6 as the questions are imported from the databases*/
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Quiz quiz = new Quiz();
        Class.forName("com.mysql.jdbc.Driver");

        //2. Connection Establish
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","");

        //fetch question from database
        List<QuizQuestion> questions = new ArrayList<>(quiz.getQuestions(conn));
        Collections.shuffle(questions);

        for(QuizQuestion question : questions){
            quiz.displayQuestion(question);

            String userAns = quiz.getUserAns();
            quiz.checkAns(question, userAns);
        }

        System.out.println("Total score: " + quiz.score + "/5");

        //4. Clean environment
        conn.close();


    }
}