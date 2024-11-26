// LSP Correct Implementation with Abstract Shape
public class App {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 5);
        System.out.println("Rectangle area: " + rectangle.area());

        Shape square = new Square(5);
        System.out.println("Square area: " + square.area());
                
        // Setting different side lengths for square and rectangle independently
        Square sq = (Square) square;
        sq.setSide(6);
        System.out.println("Square area after setting side to 6: " + sq.area());

        // Rectangle can still have different width and height
        Rectangle rect = (Rectangle) rectangle;
        rect.setWidth(15);
        rect.setHeight(8);
        System.out.println("Rectangle area after setting width and height: " + rect.area());
    }
}
