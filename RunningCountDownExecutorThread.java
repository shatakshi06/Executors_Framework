import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunningCountDownExecutorThread {
    
    public static void main(String args[]) {

        System.out.println("Attention: " + Thread.currentThread().getName() + " Starts here");

        ExecutorService executorService = Executors.newCachedThreadPool(new NamingThreadFactory());

        CountDownLatch downLatch = new CountDownLatch(2);

        executorService.execute(new ExecutorThreadWaitFinish(downLatch));
        executorService.execute(new ExecutorThreadWaitFinish(downLatch));

        executorService.shutdown();

        try {
            downLatch.await();
            System.out.println("Resuming the action of " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Attention: " + Thread.currentThread().getName() + " Ends here");
    }
}
