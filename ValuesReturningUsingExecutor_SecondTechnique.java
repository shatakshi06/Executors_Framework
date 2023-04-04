import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ValuesReturningUsingExecutor_SecondTechnique implements Callable<TaskResult<String , Integer>>{
    
    private int a,b;
    private long sleep;
    private static int count;
    private int instanceId;
    private String taskId;

    public ValuesReturningUsingExecutor_SecondTechnique(int a, int b, int sleep) {
        this.a = a;
        this.b = b;
        this.sleep = sleep;

        instanceId = ++count;
        taskId = "ValuesReturningUsingExecutor_SecondTechnique " + instanceId;  
    }

    @Override
    public TaskResult<String , Integer> call() throws InterruptedException {
        
        System.out.println("<" + Thread.currentThread().getName() + ">Starting and Executing Task " 
         + taskId);

            TimeUnit.MILLISECONDS.sleep(sleep);

        System.out.println("<" + Thread.currentThread().getName() + ">Ended and executed the Task " 
         + taskId);

        return new TaskResult<String,Integer>(taskId, a+b);
    }
}
