abstract class Shape {
    abstract void calculateArea();
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    void calculateArea() {
        double area = length * width;
        System.out.println("Rectangle Area: " + area);
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    void calculateArea() {
        double area = 3.14 * radius * radius;
        System.out.println("Circle Area: " + area);
    }
}

public class ShapeTest {
    public static void main(String args[]) {
        Shape rectangle = new Rectangle(10, 5);
        Shape circle = new Circle(7);
        rectangle.calculateArea();
        circle.calculateArea();
    }
}
