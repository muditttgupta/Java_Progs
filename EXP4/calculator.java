class add {
    int a;
    int b;
    int c;
    double d;
    double e;

    add(int n1, int n2) {
        a = n1;
        b = n2;
    }

    add(double n1, double n2) {
        d = n1;
        e = n2;
    }

    add(int n1, int n2, int n3) {
        a = n1;
        b = n2;
        c = n3;
    }

    void IntAdd() {
        System.out.println("addition " + (a + b));
    }

    void DublAdd() {
        System.out.println("addition " + (d + e));
    }

    void IntAdd3() {
        System.out.println("addition " + (a + b + c));

    }

}

class calculator {
    public static void main(String[] args) {
        add o1 = new add(10, 20);
        o1.IntAdd(); // returns the sum of type integer
        add o2 = new add(11.2, 8.8);
        o2.DublAdd();// returns the sum of type double
        add o3 = new add(12, 10, 18);
        o3.IntAdd3(); // returns the sum of type inetger
    }
}