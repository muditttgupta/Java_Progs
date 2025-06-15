class Finalgrade {
    public static void main(String[] args) {
        int m1 = Integer.parseInt(args[0]);
        int m2 = Integer.parseInt(args[1]);
        int m3 = Integer.parseInt(args[2]);

        int average = (m1 + m2 + m3) / 3;
        char grade;

        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 50) grade = 'C';
        else grade = 'F';

        System.out.println("Final Grade: " + grade);
    }
}
