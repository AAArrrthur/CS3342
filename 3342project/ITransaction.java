
public interface ITransaction {
    String getTransactionId();
    String getBuyerId();
    String getSellerId();
    String getItemId();
    double getAmount();
    String getPaymentMethod();
    void setPaymentMethod(String paymentMethod);
    String getShippingMethod();
    void setShippingMethod(String shippingMethod);
    String getStatus();
    void setStatus(String status);
}