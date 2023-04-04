public class TaskResult<S,R> {
    
    private final S taskId;
    private final R resultTask;
    
    public TaskResult(S taskId, R resultTask) {
        this.taskId = taskId;
        this.resultTask = resultTask;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
        result = prime * result + ((resultTask == null) ? 0 : resultTask.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TaskResult other = (TaskResult) obj;
        if (taskId == null) {
            if (other.taskId != null)
                return false;
        } else if (!taskId.equals(other.taskId))
            return false;
        if (resultTask == null) {
            if (other.resultTask != null)
                return false;
        } else if (!resultTask.equals(other.resultTask))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "$$$$$$$$$$$TaskResult [taskId=" + taskId + ", resultTask=" + resultTask + "]$$$$$$$$$$$$$";
    }

    
}
