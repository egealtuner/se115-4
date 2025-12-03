public class Robot {
    private String modelName;
    private int batteryLevel;
    private String status;
    public Robot(String modelName, int batteryLevel, String status) {
        this.modelName = modelName;
        this.batteryLevel = batteryLevel;
        this.status = status;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void displayRobotInfo() {
        System.out.println("Robot Model: " + modelName);
        System.out.println("Battery Level: " + batteryLevel + "%");
        System.out.println("Status: " + status);
    }
    public boolean isBatteryEnough(int requiredAmount) {
        return batteryLevel >= requiredAmount;
    }
    public void consumeBattery(int amount) {
        if (isBatteryEnough(amount)) {
            batteryLevel -= amount;
        } else {
            System.out.println("Not enough battery to consume " + amount + " units.");
        }
    }
    public void chargeBattery(int amount) {
        batteryLevel += amount;
        if (batteryLevel >= 100) {
            batteryLevel = 100;
            status = "Active";
        } else {
            status = "Charging";
        }
    }
    public void performTask(Task t) {
        System.out.println(modelName + " is attempting task: " + t.getTaskName());
        if (status.equals("Charging")) {
            System.out.println("Task failed: " + modelName + " is currently charging.");
            return;
        }
        int required = t.getEnergyCost();
        if (isBatteryEnough(required)) {
            consumeBattery(required);
            System.out.println("Task completed: " + t.getTaskName());
        } else {
            System.out.println("Task failed: not enough battery for " + t.getTaskName());
        }
    }
    public void performTaskBatch(TaskBatch batch) {
        Task[] tasks = batch.getTasks();
        if (tasks.length == 0) {
            System.out.println("Error: batch has no tasks.");
            return;
        }
        int totalCost = batch.getTotalEnergyCost();
        if (!isBatteryEnough(totalCost)) {
            System.out.println("Error: " + modelName
                    + " does not have enough battery for the whole batch.");
            return;
        }
        System.out.println(modelName + " is processing the task batch...");
        for (Task t : tasks) {
            performTask(t);
        }
        System.out.println("Updated robot information after batch:");
        displayRobotInfo();
    }
}
