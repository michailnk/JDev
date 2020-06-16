package JavaOOP.hw_Hotel.hotel.Model;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TaskTimer {
    Timer timer;
 static    boolean isPayment;

    void checkPayment(long awaitPayment) {
        TimerTask timerTask = new TimerTask( ) {
            @Override
            public void run() {
//Checking the payment
                Scanner sc = new Scanner(System.in);
                String str = sc.next( );
                if (str.chars( ).allMatch(Character::isDigit)) {
                    if (Double.parseDouble(str) != 0)
                        isPayment = true;
                }
                isPayment = false;
                timer.cancel();
            }
        };
        timer = new Timer();
        timer.schedule(timerTask,awaitPayment);
    }
    public static boolean startTimer(long daley){
        TaskTimer ts = new TaskTimer();
        ts.checkPayment(daley);
        return  isPayment;
    }
}
