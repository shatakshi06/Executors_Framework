import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunningReturningUsingExecutor {
    
    public static void main(String args[]) throws InterruptedException, ExecutionException {

        System.out.println("<" + Thread.currentThread().getName() + ">Starting........");

        // Creating a thread pool with Cached number of threads.
        ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());

        Future<Integer> firstResult = executorService.submit(new ValuesReturningUsingExecutor(24, 78, 2000));
        Future<Integer> secondResult = executorService.submit(new ValuesReturningUsingExecutor(89, 178, 1000));
        Future<Integer> thirdResult = executorService.submit(new ValuesReturningUsingExecutor(2, 78, 500));

        Future<?> fourthResult = executorService.submit(new TaskD());
        Future<Double> fifthResult = executorService.submit(new TaskD() , 98.987);

        System.out.println("firstResult: " + firstResult.get());
        System.out.println("secondResult: " + secondResult.get());
        System.out.println("thirdResult: " + thirdResult.get());
        System.out.println("fourthResult: " + fourthResult.get());
        System.out.println("fifthResult: " + fifthResult.get());

        executorService.shutdown();

        System.out.println("<" + Thread.currentThread().getName() + ">Ending........");
    }
}
