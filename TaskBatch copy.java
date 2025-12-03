public class TaskBatch {
    private Task[] tasks;
    private int taskCount;
    public TaskBatch() {
        tasks = new Task[5]; // max batch size
        taskCount = 0;
    }
    public void addTask(Task t) {
        if (taskCount < 5) {
            tasks[taskCount] = t;
            taskCount++;
        } else {
            System.out.println("Error: batch already has 5 tasks. Cannot add more.");
        }
    }
    public int getTotalEnergyCost() {
        if (taskCount == 0) {
            System.out.println("No tasks in the batch.");
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < taskCount; i++) {
            sum += tasks[i].getEnergyCost();
        }
        return sum;
    }
    public Task[] getTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks in the batch.");
            return new Task[0];
        }
        Task[] current = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            current[i] = tasks[i];
        }
        return current;
    }
    public void printBatchInfo() {
        if (taskCount == 0) {
            System.out.println("Task batch is empty.");
            return;
        }
        System.out.println("Task batch information:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println("- " + tasks[i].getTaskName()
                    + " (Energy cost: " + tasks[i].getEnergyCost() + ")");
        }
    }
}
