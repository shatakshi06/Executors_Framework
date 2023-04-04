import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFixedThreadPool {
    
    public static void main(String args[]) {

        System.out.println("Starting of main thread........");

        // Creating a thread pool with fixed number of threads.
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        ExecutorService executorServiceForTaskB = Executors.newFixedThreadPool(4);

        for(int i=0; i<4; i++) {
            executorService.execute(new TaskA());
            executorServiceForTaskB.execute(new TaskB());
        }

        // To shutdown the executor service
        executorService.shutdown();
        executorServiceForTaskB.shutdown();

        // Running a task after shutdown will throw: RejectedExecutionException
        // executorService.execute(new TaskA());

        System.out.println("End of main thread.............");
    }
}
