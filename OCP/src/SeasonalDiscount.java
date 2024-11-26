public class SeasonalDiscount implements IDiscount {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.2;  // 20% discount
    }
}
