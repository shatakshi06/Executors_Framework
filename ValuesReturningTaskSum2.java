import java.util.concurrent.TimeUnit;

/*
 * This class demonstrates how we return values from the tasks using the 
 * Threads API by making use of Callback and Observer pattern.
 * 
*/
public class ValuesReturningTaskSum2 implements Runnable{
    
    private int a,b,sum;
    private long sleep;
    private static int count;
    private int instanceId;
    private String taskId;

    private SumListener<Integer> sumListener;

    public ValuesReturningTaskSum2(int a, int b, int sleep, SumListener<Integer> sumListener) {
        this.a = a;
        this.b = b;
        this.sleep = sleep;
        this.sumListener = sumListener;

        instanceId = ++count;
        taskId = "ValuesReturningTaskSum2 " + instanceId;  
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

         sumListener.notifyResult(sum);
    }
}
