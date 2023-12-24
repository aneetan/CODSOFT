public class CounterTime implements Runnable{
    private long timeRemainingInSeconds;
    private boolean timeUp;

    CounterTime(long initialTimeInSeconds) {
        this.timeRemainingInSeconds = initialTimeInSeconds;
        this.timeUp = false;
    }

    @Override
    public void run() {
        if (timeRemainingInSeconds > 0) {
//            System.out.print("\r" + timeRemainingInSeconds);
            timeRemainingInSeconds--;
        } else if (!timeUp){
            timeUp = true;
            System.out.println("Sorry, time's up!");
            System.out.println("Skipping to the next question....");
        }
    }
    boolean isTimeUp() {
        return timeUp;
    }


}
