public class NamingThreadAtRunTime {
    
    public static void main(String args[]) {

        System.out.println("Starting of: " + Thread.currentThread().getName() + " thread........");

        new Thread(new TaskD() , "Worker - 1").start();

        Thread newThread = new Thread(new TaskD());
        // newThread.setName("Worker - 2");
        newThread.start();

        // If we are setting the name of the Thread after it has started.
        newThread.setName("Worker - 2");

        System.out.println("Ending of: " + Thread.currentThread().getName() + " thread........");
    }
}
