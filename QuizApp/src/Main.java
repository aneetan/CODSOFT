import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

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

        long questionTimeoutInSeconds = 15;  //in seconds
        ScheduledExecutorService timerExecutor = Executors.newScheduledThreadPool(1);

        for (QuizQuestion question : questions) {

            // Set up a countdown timer task
            CounterTime time = new CounterTime(questionTimeoutInSeconds);
            ScheduledFuture<?> timerTask = timerExecutor.scheduleAtFixedRate(time,0, 1, TimeUnit.SECONDS);

            // Display the question
            System.out.println("Timer: 15 seconds");
            quiz.displayQuestion(question);

            String userAns = quiz.getUserAns();

            // Stop the timer
            timerTask.cancel(true);

            // Check the timer status and handle accordingly
            if (time.isTimeUp()) {
                continue;
            } else {
                quiz.checkAns(question, userAns);
            }
        }

        // Shutdown the timer executor
        timerExecutor.shutdown();

        System.out.println("Total score: " + quiz.score + "/5");

        //4. Clean environment
        conn.close();


    }


}