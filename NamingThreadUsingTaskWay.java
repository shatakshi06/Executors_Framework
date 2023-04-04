public class NamingThreadUsingTaskWay {
    
    public static void main(String args[]) {

        System.out.println("Starting of: " + Thread.currentThread().getName() + " thread........");

        new Thread(new TaskC()).start();

        Thread newThread = new Thread(new TaskC());
        newThread.start();

        System.out.println("Ending of: " + Thread.currentThread().getName() + " thread........");
    }
}
