import java.util.concurrent.TimeUnit;

/*
 * This class demonstrates how we return values from the tasks using the 
 * Threads API.
 * 
 * The sum is returned before the task is executed and hence we have to apply the wait & 
 * notify mechanism.
*/
public class ValuesReturningTaskSum implements Runnable{
    
    private int a,b,sum;
    private long sleep;
    private static int count;
    private int instanceId;
    private String taskId;
    private volatile boolean status = false;

    public ValuesReturningTaskSum(int a, int b, int sleep) {
        this.a = a;
        this.b = b;
        this.sleep = sleep;

        instanceId = ++count;
        taskId = "ValuesReturningTaskSum " + instanceId;  
    }

    @Override
    public void run() {
        
        System.out.println("<" + Thread.currentThread().getName() + ">Starting and Executing Task " 
         + taskId);

            try {
                TimeUnit.MILLISECONDS.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sum = a + b;

        System.out.println("<" + Thread.currentThread().getName() + ">Ended and executed the Task " 
         + taskId);

            status = true;

            synchronized(this) {
                System.out.println("<" + Thread.currentThread().getName() + "> is notifying for the task " 
                    + taskId);
                this.notify();
            }
    }

    public int add() {
       synchronized(this) {
            if(!status) {
                try {
                    System.out.println("<" + Thread.currentThread().getName() + "> is waiting for the result of the task " 
                    + taskId);
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }


}
