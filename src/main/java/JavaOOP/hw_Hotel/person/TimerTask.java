package JavaOOP.hw_Hotel.person;

import java.util.Timer;
import java.util.TimerTask;

class TimerTest {
    private Timer timer;

    public void cancelTimer() {
        timer.cancel( );
        System.out.println("Canceled timer!");
    }

    public void startTimer() {
        TimerTask timerTask = new TimerTask( ) {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace( );
                }
                System.out.println("Hello there!");
            }
        };
        this.timer = new Timer( );
        System.out.println("Starting timer ...");
        int period = 5000;
        this.timer.schedule(timerTask, 0, period);
    }

    public static void start() throws InterruptedException {
        TimerTest tt = new TimerTest( );
        tt.startTimer( );
        // Thread.sleep(3000);
        tt.cancelTimer( ); // you can call this method, as soon as u have a correct answer

    }
}