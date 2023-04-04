import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunningReturningUsingExecutor_Second {
    
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        System.out.println("<" + Thread.currentThread().getName() + ">Starting........");

        // Creating a thread pool with Cached number of threads.
        ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());

        CompletionService<TaskResult<String , Integer>> completionService = new 
                          ExecutorCompletionService<TaskResult<String , Integer>>(executorService);

        executorService.submit(new ValuesReturningUsingExecutor_SecondTechnique(24, 78, 2000));
        executorService.submit(new ValuesReturningUsingExecutor_SecondTechnique(89, 178, 1000));
        executorService.submit(new ValuesReturningUsingExecutor_SecondTechnique(2, 78, 500));

        executorService.submit(new TaskD() , new TaskResult<String,Integer>("Task-D", 999));

        for(int i=0 ; i<3 ; i++) {

            System.out.println(completionService.take().get());
        }
        
        executorService.shutdown();

        System.out.println("<" + Thread.currentThread().getName() + ">Ending........");
    }
}
