public class PercentageDiscount implements IDiscount {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.1;  // 10% discount
    }
}
