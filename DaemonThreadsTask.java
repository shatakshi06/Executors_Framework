import java.util.concurrent.TimeUnit;

public class DaemonThreadsTask implements Runnable{
    
    private static int count = 0;
    private int instanceId;
    private String taskId;
    private long sleepTime;

    @Override
    public void run() {

       boolean isDaemonThread = Thread.currentThread().isDaemon(); 
       String currentThreadName = Thread.currentThread().getName();
       String userOrDaemon = isDaemonThread ? "DAEMON " : "USER ";

       System.out.println("**************Start of the " + userOrDaemon + " Thread: " + currentThreadName + 
                         " with id <" + taskId +  ">**************"); 

       for(int i=10; i>0; i--) {
           System.out.println("<" + userOrDaemon + currentThreadName + "> TICK TOCK: " + i);

           try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
       }
       System.out.println("**************End of the " + userOrDaemon + " Thread: " + currentThreadName + " with id <" 
                         + taskId +  ">**************"); 
    }

    public DaemonThreadsTask(long sleepTIme) {
        this.sleepTime = sleepTIme;
        instanceId = ++count;
        taskId = "DaemonThreadsTask" + instanceId;
    }
}