import java.util.concurrent.TimeUnit;

public class TaskC implements Runnable{
    
    private static int count = 0;
    private int instanceId;
    private String taskId;

    @Override
    public void run() {

        // Naming the thread from within the task: 1st way of naming the thread
        // It is not a preffered approach.
       Thread.currentThread().setName("Worker Thread " + instanceId); 
       String currentThreadName = Thread.currentThread().getName();

       System.out.println("**************Start of the Thread: " + currentThreadName + 
                         " with id <" + taskId +  ">**************"); 

       for(int i=10; i>0; i--) {
           System.out.println("<" + currentThreadName + "> TICK TOCK: " + i);

           try {
                TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
       }
       System.out.println("**************End of the Thread: " + currentThreadName + " with id <" 
                         + taskId +  ">**************"); 
    }

    public TaskC() {
        instanceId = ++count;
        taskId = "TaskC" + instanceId;
    }
}
