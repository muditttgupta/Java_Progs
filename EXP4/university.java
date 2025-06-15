class Student {
    // Static variable (shared among all instances)
    static String universityName = "UPES";
    
    // Non-static variable (unique for each instance)
    String studentName;

    // Constructor to initialize student name
    public Student(String studentName) {
        this.studentName = studentName;
    }

    // Static method to display university name
    static void displayUniversityName() {
        System.out.println("University: " + universityName);
    }

    // Method to display student details
    void displayStudentInfo() {
        System.out.println("Student Name: " + studentName);
        System.out.println("University: " + universityName);
    }

    public static void main(String[] args) {
        // Calling static method without creating an object
        Student.displayUniversityName();

        // Creating student objects
        Student student1 = new Student("Mudit");
        Student student2 = new Student("Arnav");
        Student student3 = new Student("Agrim");

        // Displaying student information
        student1.displayStudentInfo();
        student2.displayStudentInfo();
        student3.displayStudentInfo();
    }
}


