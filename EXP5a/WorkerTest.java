abstract class Worker {
    protected String name;
    protected double salaryRate;
    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }
    public abstract double computePay(int hours);
}
class DailyWorker extends Worker {
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }
    public double computePay(int hours) {
        int daysWorked = hours / 8;
        return daysWorked * salaryRate;
    }
}
class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }

    public double computePay(int hours) {
        return 40 * salaryRate;
    }
}
public class WorkerTest {
    public static void main(String[] args) {
        Worker dailyWorker = new DailyWorker("John", 100); // Daily rate
        Worker salariedWorker = new SalariedWorker("Alice", 50); // Hourly rate

        System.out.println("Daily Worker Pay: " + dailyWorker.computePay(40)); // 5 days * 100
        System.out.println("Salaried Worker Pay: " + salariedWorker.computePay(50)); // Fixed 40 hours * 50
    }
}
