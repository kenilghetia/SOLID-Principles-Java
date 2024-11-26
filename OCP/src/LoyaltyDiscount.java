public class LoyaltyDiscount implements IDiscount {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.15; // 15% discount
    }
}
