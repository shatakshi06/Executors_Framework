import java.util.concurrent.ThreadFactory;

/*
 * This class is used to name the threads using Executors.
*/
public class NamingThreadFactory implements ThreadFactory{

    private static int count = 0;
    private String Name = "PoolWorker- ";

    @Override
    public Thread newThread(Runnable r) {
        Thread nThread = new Thread(r , Name + ++count );
        return nThread;
    }
}
