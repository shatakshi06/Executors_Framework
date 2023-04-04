public class RunningReturningTaskSum2 {
    
    public static void main(String args[]) {

        System.out.println("<" + Thread.currentThread().getName() + ">Starting........");

        ValuesReturningTaskSum2 task1 = new ValuesReturningTaskSum2(10, 20, 2000, new SumObserver("task1"));
        Thread t1 = new Thread( task1 , "SumThread 1" );

        ValuesReturningTaskSum2 task2 = new ValuesReturningTaskSum2(5, 27, 1000, new SumObserver("task2"));
        Thread t2 = new Thread( task2 , "SumThread 2" );

        ValuesReturningTaskSum2 task3 = new ValuesReturningTaskSum2(100, 270, 500, new SumObserver("task3"));
        Thread t3 = new Thread( task3 , "SumThread 3" );

        t1.start();
        t2.start();
        t3.start();

        System.out.println("<" + Thread.currentThread().getName() + ">Ending........");
    }
}
