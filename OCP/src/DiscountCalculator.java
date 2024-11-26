public class DiscountCalculator {
    private IDiscount discountStrategy;

    // Constructor allows setting the strategy at runtime
    public DiscountCalculator(IDiscount discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateDiscount(Product product) {
        return discountStrategy.calculateDiscount(product);
    }
}
