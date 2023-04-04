import java.util.concurrent.TimeUnit;

class TaskA implements Runnable {

    private static int count = 0;
    private int id;

    @Override
    public void run() {
       System.out.println("*******************Start of the Task A with id <" + id +  ">**************"); 
       for(int i=10; i>0; i--) {
           System.out.println("<" + id + "> TICK TOCK: " + i);

           try {
                TimeUnit.MILLISECONDS.sleep((long)Math.random()*1000);
           } catch (InterruptedException e) {
                e.printStackTrace();
           }
       }
       System.out.println("##################End of the Task A with id <" + id +  ">**************");
    }

    public TaskA() {
        id = ++count;
    }
}