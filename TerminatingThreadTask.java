import java.util.concurrent.TimeUnit;

public class TerminatingThreadTask implements Runnable {
    
    private static int count = 0;
    private int instanceId;
    private String taskId;
    private volatile boolean check = false;

    @Override
    public void run() {

       String currentThreadName = Thread.currentThread().getName();
       System.out.println("**************Start of the Thread: " + currentThreadName + 
                         " with id <" + taskId +  ">**************"); 

       for(int i=1; ;i++) {
           System.out.println("<" + currentThreadName + "> TICK TOCK: " + i);
           try {
                TimeUnit.MILLISECONDS.sleep((long)Math.random()*3000);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }

           synchronized(this) {
              if(check) {
                break;
              }
           }

           System.out.println("**************End of the Thread: " + currentThreadName + 
                         " with id <" + taskId +  ">**************"); 
       }  
    }

    public void cancel() {
        System.out.println("Terminating the thread with the id: " + taskId);
         synchronized(this) {
            this.check = true;
         }
    }

    public TerminatingThreadTask() {
        instanceId = ++count;
        taskId = "TerminatingThreadTask " + instanceId;
    }
}


