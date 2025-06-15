class SuperClass {
    private final int privateVar;

    public SuperClass() {                  //constructor
        this.privateVar = 42; 
    }

    public void showPrivateVar() {          //method
        System.out.println("Private Variable: " + privateVar);
    }
}

class SubClass extends SuperClass {
    public void display() {                 // calling superclass method to show private variable
        showPrivateVar();
    }
}

public class Private {
    public static void main(String[] args) {
        SubClass obj = new SubClass();
        obj.display();
    }
}
