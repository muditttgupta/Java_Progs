// File: p/A.java
package p;  // ✅ Ensure this package declaration is present

public class A {
    public void publicMethod() {
        System.out.println("Public method is accessible everywhere.");
    }

    protected void protectedMethod() {
        System.out.println("Protected method is accessible within the same package and in subclasses.");
    }

    void defaultMethod() {
        System.out.println("Default method is accessible within the same package only.");
    }

    private void privateMethod() {
        System.out.println("Private method is accessible only within the same class.");
    }

    public void accessPrivateMethod() {
        System.out.println("Accessing private method within class A:");
        privateMethod();
    }
}

