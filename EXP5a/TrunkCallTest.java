import java.util.Scanner;
abstract class TrunkCall {
    protected int duration;
    public TrunkCall(int duration) {
        this.duration = duration;
    }
    public abstract double calculateCharge();
}
class OrdinaryCall extends TrunkCall {
    private static final double RATE = 1.5; 
    public OrdinaryCall(int duration) {
        super(duration);
    }
    public double calculateCharge() {
        return duration * RATE;
    }
}
class UrgentCall extends TrunkCall {
    private static final double RATE = 2.5; // Rate per minute
    public UrgentCall(int duration) {
        super(duration);
    }
    public double calculateCharge() {
        return duration * RATE;
    }
}
class LightningCall extends TrunkCall {
    private static final double RATE = 5.0; // Rate per minute
    public LightningCall(int duration) {
        super(duration);
    }
    public double calculateCharge() {
        return duration * RATE;
    }
}
public class TrunkCallTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter call duration (in minutes): ");
        int duration = scanner.nextInt();
        System.out.println("Select call type: 1. Ordinary 2. Urgent 3. Lightning");
        int choice = scanner.nextInt();
        TrunkCall call;
        switch (choice) {
            case 1:
                call = new OrdinaryCall(duration);
                break;
            case 2:
                call = new UrgentCall(duration);
                break;
            case 3:
                call = new LightningCall(duration);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        System.out.println("Total charge: Rs. " + call.calculateCharge());
        scanner.close();
    }
}

