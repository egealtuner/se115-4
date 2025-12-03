import java.util.Scanner;
public class FactoryDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Robot r1 = new Robot("RoboAlpha", 80, "Active");
        Robot r2 = new Robot("RoboBeta", 50, "Active");
        System.out.println("Initial robots:");
        r1.displayRobotInfo();
        r2.displayRobotInfo();
        System.out.print("Enter battery amount for " + r1.getModelName() + " to consume: ");
        int amount = input.nextInt();
        if (r1.isBatteryEnough(amount)) {
            r1.consumeBattery(amount);
            System.out.println("Battery consumption succeeded.");
        } else {
            System.out.println("Battery consumption failed (not enough battery).");
        }
        System.out.println("Robot after consumption:");
        r1.displayRobotInfo();
        Task t1 = new Task("Welding", 30);
        Task t2 = new Task("Painting", 20);
        Task t3 = new Task("Heavy lifting", 40);
        System.out.println("Checking if " + r1.getModelName()
                + " has enough battery for task " + t1.getTaskName());
        if (r1.isBatteryEnough(t1.getEnergyCost())) {
            System.out.println("Yes, enough battery.");
        } else {
            System.out.println("No, not enough battery.");
        }
        System.out.println("\nBefore performing a task:");
        r1.displayRobotInfo();
        t1.describeTask();
        r1.performTask(t1);
        System.out.println("After performing the task:");
        r1.displayRobotInfo();
        TaskBatch batch = new TaskBatch();
        batch.addTask(t1);
        batch.addTask(t2);
        batch.addTask(t3);
        batch.printBatchInfo();
        int totalCost = batch.getTotalEnergyCost();
        System.out.println("Total energy cost of batch: " + totalCost);
        // BONUS:
        System.out.println("\nRobot battery before batch:");
        r1.displayRobotInfo();
        r1.performTaskBatch(batch);
        System.out.println("Robot battery after batch:");
        r1.displayRobotInfo();
        input.close();
    }
}
