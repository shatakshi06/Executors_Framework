import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Single Thread Executor executed thread one at a time.
 * It goes on to the next thread when the first thread finishes its execution.
*/
public class UsingSingleThreadPool {
    
    public static void main(String args[]) {

        System.out.println("Starting of main thread........");

        // Creating a thread pool with Single thread executor.
        ExecutorService executorService = Executors.newSingleThreadExecutor();

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
