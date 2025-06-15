class Employee {
    int employeeID;
    String name;
    String department;
    double salary;
    static int totalEmployees = 0;

    Employee() {
        this.employeeID = 0;
        this.name = "Unknown";
        this.department = "Unknown";
        this.salary = 0.0;
        totalEmployees++; 
    }

    Employee(int employeeID, String name, String department, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.salary = salary;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total number of employees: " + totalEmployees);
    }
    public double calculateSalary() {
        return salary;
    }
    public void displayEmployeeInfo() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs" + salary);
    }

    public double getSalary() {
        return salary;
    }

    public static void main(String args[]) {
        Employee emp1 = new Employee();

        Employee emp2 = new Employee(101, "Mudit Gupta", "Engineering", 60000);
        Employee emp3 = new Employee(102, "Arnav", "Marketing", 50000);

        Employee.displayTotalEmployees();

        System.out.println("\nEmployee 1 Details:");
        emp1.displayEmployeeInfo();

        System.out.println("\nEmployee 2 Details:");
        emp2.displayEmployeeInfo();

        System.out.println("\nEmployee 3 Details:");
        emp3.displayEmployeeInfo();
    }
}
