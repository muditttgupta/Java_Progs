// File: q/B.java
package q;  // ✅ Ensure this package declaration is present

import p.A; // ✅ Import class A from package p

public class B {
    public static void main(String[] args) {
        A obj = new A();  // ✅ Creating an object of A

        obj.publicMethod();   // ✅ Allowed (public method)
        // obj.protectedMethod(); // ❌ Not allowed (different package without inheritance)
        // obj.defaultMethod(); // ❌ Not allowed (default methods are not accessible outside the package)
        // obj.privateMethod(); // ❌ Not allowed (private methods are not accessible anywhere)

        obj.accessPrivateMethod(); // ✅ Public method calling private method internally
    }
}
