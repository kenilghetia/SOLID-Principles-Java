// Follows OCP: Open for extension, closed for modification
public class Main {
    public static void main(String[] args) {
        Product product = new Product("Laptop", 80000);

        // Calculate percentage discount
        DiscountCalculator percentageCalculator = new DiscountCalculator(new PercentageDiscount());
        System.out.println("Percentage discount: " + percentageCalculator.calculateDiscount(product));

        // Calculate seasonal discount
        DiscountCalculator seasonalCalculator = new DiscountCalculator(new SeasonalDiscount());
        System.out.println("Seasonal discount: " + seasonalCalculator.calculateDiscount(product));

        // Calculate loyalty discount
        DiscountCalculator loyaltyCalculator = new DiscountCalculator(new LoyaltyDiscount());
        System.out.println("Loyalty discount: " + loyaltyCalculator.calculateDiscount(product));

        // Calculate bulk purchase discount
        DiscountCalculator bulkCalculator = new DiscountCalculator(new BulkPurchaseDiscount());
        System.out.println("Bulk purchase discount: " + bulkCalculator.calculateDiscount(product));
    }
}
