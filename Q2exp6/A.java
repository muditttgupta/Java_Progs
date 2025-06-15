package p;

public class A {
    public void publicMethod() {
        System.out.println("Public Method: Accessible everywhere.");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method: Accessible within the same package and subclasses.");
    }

    void defaultMethod() {
        System.out.println("Default Method: Accessible within the same package only.");
    }

    private void privateMethod() {
        System.out.println("Private Method: Accessible only within this class.");
    }

    public void accessPrivateMethod() {
        privateMethod();
    }
}



