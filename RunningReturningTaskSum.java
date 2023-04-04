
/*
 * This class demonstrates how we return values from the tasks using the 
 * Threads API.
 * 
 * The sum is returned before the task is executed and hence we have to apply the wait & 
 * notify mechanism.
*/

public class RunningReturningTaskSum {
    
    public static void main(String args[]) {

        System.out.println("<" + Thread.currentThread().getName() + ">Starting........");

        ValuesReturningTaskSum task1 = new ValuesReturningTaskSum(10, 20, 2000);
        Thread t1 = new Thread( task1 , "SumThread 1" );

        ValuesReturningTaskSum task2 = new ValuesReturningTaskSum(5, 27, 1000);
        Thread t2 = new Thread( task2 , "SumThread 2" );

        ValuesReturningTaskSum task3 = new ValuesReturningTaskSum(100, 270, 500);
        Thread t3 = new Thread( task3 , "SumThread 3" );

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Result by Task 1: " + task1.add());
        System.out.println("Result by Task 2: " + task2.add());
        System.out.println("Result by Task 3: " + task3.add());

        System.out.println("<" + Thread.currentThread().getName() + ">Ending........");
    }
}
