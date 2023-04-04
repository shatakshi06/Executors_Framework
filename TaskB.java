public class TaskB implements Runnable{

    private static int count = 0;
    private int id;

    public TaskB() {
        id = ++count;
    }

    @Override
    public void run() {
        System.out.println("*******************Start of the Task B with id <" + id +  ">**************"); 

        System.out.println("Hi, My name is Task B");
        
        System.out.println("##################End of the Task B with id <" + id +  ">**************");
    }
    
}
