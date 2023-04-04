
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class OneExecutionThreadsTechniqueTask extends TimerTask {

    private static int count = 0;
    private int instanceId;
    private String taskId;
    private long sleepTime;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        Date startTime = new Date();
        Date scheduleTime = new Date(super.scheduledExecutionTime());
        System.out.println("Start of the Thread: " + currentThreadName + 
                          " with id <" + taskId +  "> with the start time as: " + dateFormat.format(startTime)
                          + "& is scheduled at: " + dateFormat.format(scheduleTime)); 

        for(int i=10; i>0; i--) {
           System.out.println("<" + currentThreadName + "> TICK TOCK: " + i);

           try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
        }
        Date endTime = new Date();
        
        System.out.println("End of the Thread: " + currentThreadName + " with id <" 
                         + taskId +  "> is expected a schedule dalay of: " + 
                         TimeUtils.getTimeDiffernceInSeconds(scheduleTime, startTime)
                         + " & the execution took to complete: " +
                         TimeUtils.getTimeDiffernceInSeconds(endTime, startTime));
    }

    public OneExecutionThreadsTechniqueTask(long sleepTime) {

        this.sleepTime = sleepTime;
        instanceId = ++count;
        taskId = "OneExecutionThreadsTechniqueTask" + instanceId;
    }
    
   
}
