import java.util.ArrayList;

class Employee {
    String name;
    int id;
    double salary;
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}

public class EmployeeManagement {
    public static void main(String args[]) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mudit", 101, 50000));
        employees.add(new Employee("Agrim", 102, 60000));
        employees.add(new Employee("Raghav", 103, 55000));

        for (Employee emp : employees) {
            if (emp.id == 102) {
                emp.salary = 65000;
                System.out.println("Updated salary for ID 102");
                break;
            }
        }
        employees.removeIf(emp -> emp.id == 101);
        System.out.println("Removed employee with ID 101\n");
        System.out.println("Remaining Employees:");
        for (Employee emp : employees) {
            System.out.println("ID: " + emp.id + ", Name: " + emp.name + ", Salary: Rs." + emp.salary);
        }
    }
}

