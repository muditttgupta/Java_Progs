class Employee {
    String name;
    int empid;
    double salary;

    public Employee() {
        this.name = "NA";
        this.empid = 0;
        this.salary = 0.0;
    }

    public Employee(String name, int empid, double salary) {
        this.name = name;
        this.empid = empid;
        this.salary = salary;
    }

    public void increasesalary(double percentage) {
        if (percentage > 0) {
            salary += salary * (percentage / 100);
        }
    }

    public void EmployeeDetails() {
        System.out.println("Employee ID: " + empid + ", Name: " + name + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    private String department;

    public Manager(String name, int empid, double salary, String department) {
        super(name, empid, salary);
        this.department = department;
    }

    public void ManagerDetails() {
        EmployeeDetails();
        System.out.println("Department: " + department);
    }
}

public class testprogram {
    public static void main(String args[]) {
        Employee emp1 = new Employee("Mudit", 101, 50000);
        emp1.EmployeeDetails();
        
        emp1.increasesalary(10);
        System.out.println("New Salary:");
        emp1.EmployeeDetails();

        Manager manager1 = new Manager("Mudit Gupta", 102, 70000, "IT");
        manager1.ManagerDetails();

        manager1.increasesalary(15);
        System.out.println("After Manager New Salary:");
        manager1.ManagerDetails();
    }
}



