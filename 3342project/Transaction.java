public class Transaction implements ITransaction {
    private String transactionId;
    private String buyerId;
    private String sellerId;
    private String itemId;
    private double amount;
    private String paymentMethod;
    private String shippingMethod;
    private String status;

    public Transaction(String transactionId, String buyerId, String sellerId, String itemId, double amount) {
        this.transactionId = transactionId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.itemId = itemId;
        this.amount = amount;
        this.status = "Pending";
    }

    // Getter和Setter方法
    @Override
    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String getBuyerId() {
        return buyerId;
    }

    @Override
    public String getSellerId() {
        return sellerId;
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String getShippingMethod() {
        return shippingMethod;
    }

    @Override
    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}