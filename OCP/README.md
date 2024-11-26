The Open/Closed Principle (OCP) states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that the behavior of a module can be extended without modifying its existing code.

to calculate the discount for a product. Initially, the system supports only a fixed percentage discount, but later we want to extend it to include other types of discounts, such as seasonal discounts, loyalty discounts, and bulk purchase discounts. 

In the initial design, we might have a DiscountCalculator class that calculates the discount for a product. However, if we need to add a new discount type, we will have to modify this class, which violates OCP.

Open/Closed Principle Violation: Every time we add a new discount type (e.g., bulk discount), we need to modify the DiscountCalculator class, which is not closed for modification.

// Violation of OCP
```java
class DiscountCalculator {

    public double calculateDiscount(Product product, String discountType) {
        if (discountType.equals("percentage")) {
            return product.getPrice() * 0.1;  // 10% discount
        } else if (discountType.equals("seasonal")) {
            return product.getPrice() * 0.2;  // 20% discount
        } else if (discountType.equals("loyalty")) {
            return product.getPrice() * 0.15; // 15% discount
        }
        return 0;  // No discount
    }
}
```

```java
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        DiscountCalculator discountCalculator = new DiscountCalculator();
        Product product = new Product("Laptop", 1000);

        System.out.println("Percentage discount: " + discountCalculator.calculateDiscount(product, "percentage"));
        System.out.println("Seasonal discount: " + discountCalculator.calculateDiscount(product, "seasonal"));
        System.out.println("Loyalty discount: " + discountCalculator.calculateDiscount(product, "loyalty"));
    }
}
```


To correctly apply OCP, we can extend the discount calculation logic by defining a common interface for discounts, allowing us to add new types of discounts without modifying existing classes. The DiscountCalculator class will delegate the responsibility to different discount strategies, making it open for extension and closed for modification.

Open for Extension: New discount strategies (e.g., HolidayDiscount, FlashSaleDiscount) can be added without changing any existing classes. You just need to create a new class that implements the DiscountStrategy interface.
Closed for Modification: The existing DiscountCalculator class doesn’t need to be modified when adding new discount types. We simply pass a different strategy to the DiscountCalculator constructor.
