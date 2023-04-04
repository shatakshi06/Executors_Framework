import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class RunningScheduleOfThreads {
    
    public static void main(String args[]) {

        System.out.println("<" + Thread.currentThread().getName() + ">Starting........");

        Timer timer = new Timer("Timer-Thread", false);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
        Date currentTime = new Date();
        Date scheduleTime = TimeUtils.getFutureDate(currentTime, 500);
        timer.schedule(new OneExecutionThreadsTechniqueTask(0), scheduleTime);
        System.out.println("The task-1 is scheduled to start at: " + dateFormat.format(scheduleTime));

        long millisToAdd = 10000;
        OneExecutionThreadsTechniqueTask task2 = new OneExecutionThreadsTechniqueTask(0);
        timer.schedule(task2, millisToAdd);
        System.out.println("The task-2 with a delay of: " + millisToAdd/1000 + " seconds is scheduled at: "
        + dateFormat.format(new Date(task2.scheduledExecutionTime())));

        long doubleMillisToAdd = 12000;
        OneExecutionThreadsTechniqueTask task3 = new OneExecutionThreadsTechniqueTask(0);
        //timer.schedule(task3, doubleMillisToAdd);

        timer.schedule(task3, doubleMillisToAdd, 10000);

        System.out.println("The task-3 with a delay of: " + doubleMillisToAdd/1000 + " seconds is scheduled at: "
        + dateFormat.format(new Date(task3.scheduledExecutionTime())));



        System.out.println("<" + Thread.currentThread().getName() + ">Ending........");
    }
}
