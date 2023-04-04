public class RunningDaemonThreadTask {
    
    public static void main(String args[]) {

        System.out.println("Starting of: " + Thread.currentThread().getName() + " thread........");

        Thread newThread = new Thread(new DaemonThreadsTask(400) , "Thread - 1");
        Thread newTwoThread = new Thread(new DaemonThreadsTask(200) , "Thread - 2");
        newThread.setDaemon(true);
        newThread.start();
        newTwoThread.start();

        System.out.println("Ending of: " + Thread.currentThread().getName() + " thread........");
    }
}
