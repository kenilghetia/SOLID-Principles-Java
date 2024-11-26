The Liskov Substitution Principle (LSP) states that any subclass of a superclass should be usable in place of its superclass without introducing errors or altering the expected behavior of the program. In simpler terms, if code is written to work with a specific type of object (the base class), it should also be able to work seamlessly with any of its subclasses (derived classes) without any issues or surprises.

``` java
// Base class: Rectangle
public class Rectangle {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }
}

// Derived class: Square
public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public int calculateArea() {
        return width * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle obj = new Square(5);
        
        obj.width = 5;
        obj.height = 3;

        System.out.println("Square Area: " + obj.calculateArea()); // Outputs 25
    }
}

```