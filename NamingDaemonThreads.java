public class NamingDaemonThreads extends NamingThreadFactory {

    private static int count = 0;
    private String Name = "PoolWorker- ";

    @Override
    public Thread newThread(Runnable r) {
        Thread nThread = new Thread(r , Name + ++count );
        if(++count % 2 == 0) {
            nThread.setDaemon(true);
        }
        return nThread;
    }
    
}
