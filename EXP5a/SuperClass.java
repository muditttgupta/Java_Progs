class SuperClass {
    private int privateVar = 10;
    
    public int getPrivateVar() {
        return privateVar;
    }
}

class SubClass extends SuperClass {
    void display() {
        // System.out.println(privateVar); // This will cause an error
        System.out.println("Private variable accessed through method: " + getPrivateVar());
    }
}