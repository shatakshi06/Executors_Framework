import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


public class ValuesReturningUsingExecutor implements Callable<Integer> {
    
    private int a,b,sum;
    private long sleep;
    private static int count;
    private int instanceId;
    private String taskId;

    public ValuesReturningUsingExecutor(int a, int b, int sleep) {
        this.a = a;
        this.b = b;
        this.sleep = sleep;

        instanceId = ++count;
        taskId = "ValuesReturningTaskSum2 " + instanceId;  
    }

    @Override
    public Integer call() throws InterruptedException {
        
        System.out.println("<" + Thread.currentThread().getName() + ">Starting and Executing Task " 
         + taskId);

            TimeUnit.MILLISECONDS.sleep(sleep);

            sum = a + b;

        System.out.println("<" + Thread.currentThread().getName() + ">Ended and executed the Task " 
         + taskId);

        return sum;
    }
}
