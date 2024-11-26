public class BulkPurchaseDiscount implements IDiscount {
    @Override
    public double calculateDiscount(Product product) {
        return product.getPrice() * 0.3;  // 30% discount for bulk purchase
    }
}
