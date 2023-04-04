
public class JoiningThreads {
    
    public static void main(String args[]) throws InterruptedException {

        Thread t1 = new Thread(new DaemonThreadsTask(100),"MyThread-1");
        Thread t2 = new Thread(new DaemonThreadsTask(300),"MyThread-2");
        Thread t3 = new Thread(new DaemonThreadsTask(200),"MyThread-3");
        Thread t4 = new Thread(new DaemonThreadsTask(400),"MyThread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        System.out.println("The current thread: " + Thread.currentThread().getName() + " joined thread " + t1.getName());

        t2.join();
        System.out.println("The current thread: " + Thread.currentThread().getName() + " joined thread " + t2.getName());

        t3.join();
        System.out.println("The current thread: " + Thread.currentThread().getName() + " joined thread " + t3.getName());

        t4.join();
        System.out.println("The current thread: " + Thread.currentThread().getName() + " joined thread " + t4.getName());  
    }

}
