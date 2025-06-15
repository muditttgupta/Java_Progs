abstract class Employee {
    abstract void calculateSalary();
    abstract void displayDetails();
}
class Manager extends Employee {
    String name;
    double salary;
    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    void calculateSalary() {
        System.out.println("Manager Salary: " + salary);
    }
    void displayDetails() {
        System.out.println("Name: " + name + ", Role: Manager, Salary: " + salary);
    }
}
class Developer extends Employee {
    String name;
    double hourlyRate;
    int hoursWorked;
    public Developer(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    void calculateSalary() {
        double salary = hourlyRate * hoursWorked;
        System.out.println("Developer Salary: " + salary);
    }
    void displayDetails() {
        System.out.println("Name: " + name + ", Role: Developer, Hourly Rate: " + hourlyRate + ", Hours Worked: " + hoursWorked);
    }
}
public class EmployeeTest {
    public static void main(String args[]) {
        Employee manager = new Manager("Mudit", 80000);
        Employee developer = new Developer("Agrim", 50, 160);
        manager.calculateSalary();
        manager.displayDetails();
        developer.calculateSalary();
        developer.displayDetails();
    }
}
