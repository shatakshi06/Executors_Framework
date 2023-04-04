import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * The Cached thread pool allows us to run any number of threads and 
 * starts all the threads  at the same time.
*/

public class UsingCachedThreadPool {
    
    public static void main(String args[]) {

        System.out.println("Starting of main thread........");

        // Creating a thread pool with Cached number of threads.
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0; i<4; i++) {
            executorService.execute(new TaskA());
        }

        // To shutdown the executor service
        executorService.shutdown();

        // Running a task after shutdown will throw: RejectedExecutionException
        // executorService.execute(new TaskA());

        System.out.println("End of main thread.............");
    }
}

