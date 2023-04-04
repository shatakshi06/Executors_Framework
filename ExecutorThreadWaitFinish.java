import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ExecutorThreadWaitFinish implements Runnable{
    
    private static int count = 0;
    private int instanceId;
    private String taskId;
    private CountDownLatch countDownLatch;

    @Override
    public void run() {

       String currentThreadName = Thread.currentThread().getName();

       System.out.println("**************Start of the "  + " Thread: " + currentThreadName + 
                         " with id <" + taskId +  ">**************"); 

       for(int i=10; i>0; i--) {
           System.out.println("<" + currentThreadName + "> TICK TOCK: " + i);

           try {
                TimeUnit.MILLISECONDS.sleep((long) Math.random()*1000);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
       }
       System.out.println("**************End of the "  + " Thread: " + currentThreadName + " with id <" 
                         + taskId +  ">**************"); 

       if(countDownLatch != null) {
            countDownLatch.countDown();
            System.out.println(" Thread: " + currentThreadName + " with id <" + taskId +  "> with Latch count to "
            + countDownLatch.getCount());
       }
    }

    public ExecutorThreadWaitFinish(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        instanceId = ++count;
        taskId = "ExecutorThreadWaitFinish" + instanceId;
    }
}
