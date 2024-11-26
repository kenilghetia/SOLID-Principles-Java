// Square class (inherits from Shape)
public class Square extends Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}
