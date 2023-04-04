public class SumObserver implements SumListener<Integer>{

    private String taskId;

    public SumObserver(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void notifyResult(Integer result) {
        System.out.println("The result of the sum for the task: " + taskId + " is: " + result);
    }
    
}
