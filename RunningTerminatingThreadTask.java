import java.util.concurrent.TimeUnit;

public class RunningTerminatingThreadTask {
    
    public static void main(String args[]) throws InterruptedException {

        TerminatingThreadTask task1 = new TerminatingThreadTask();
        TerminatingThreadTask task2 = new TerminatingThreadTask();
        TerminatingThreadTask task3 = new TerminatingThreadTask();

        new Thread(task1,"MyThread-1").start();
        new Thread(task2,"MyThread-2").start();
        new Thread(task3,"MyThread-3").start();

        TimeUnit.MILLISECONDS.sleep(1000);

        task1.cancel();
        task2.cancel();
        task3.cancel();

    }
}
