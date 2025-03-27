

public class AlipayPayment implements PaymentStrategy {
    @Override
    public void pay(ITransaction transaction) {
        System.out.println("Payment processed via Alipay for transaction: " + transaction.getTransactionId());
        transaction.setStatus("Payment Confirmed");
    }
}