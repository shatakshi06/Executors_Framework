import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamingExecutorThreads {
    
    public static void main(String args[]) {

        System.out.println("<" + Thread.currentThread().getName() + ">Starting........");

        // Creating a thread pool with Cached number of threads.
        ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());

        for(int i=0; i<4; i++) {
            executorService.execute(new TaskD());
        }

        System.out.println("Submitting a few more tasks....");

        TimeUnit.MILLISECONDS.toMillis(500);

        for(int i=0; i<3; i++) {
            executorService.execute(new TaskD());
        }
        // To shutdown the executor service
        executorService.shutdown();

        System.out.println("<" + Thread.currentThread().getName() + ">Ending........");
    }
}
