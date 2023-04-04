

/*
 * This section is parked.
*/

public class TerminatingThreadTaskSecondTechnique implements Runnable {
    
    private static int count = 0;
    private int instanceId;
    private String taskId;

    @Override
    public void run() {

       String currentThreadName = Thread.currentThread().getName();
       System.out.println("**************Start of the Thread: " + currentThreadName + 
                         " with id <" + taskId +  ">**************"); 

       for(int i=1; ;i++) {
           System.out.println("<" + currentThreadName + "> TICK TOCK: " + i);

           System.out.println("**************End of the Thread: " + currentThreadName + 
                         " with id <" + taskId +  ">**************"); 
       }
    }

    public TerminatingThreadTaskSecondTechnique() {
        instanceId = ++count;
        taskId = "TerminatingThreadTask " + instanceId;
    }
}


