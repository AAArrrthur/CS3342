public class CardPayment implements PaymentStrategy {
    @Override
    public void pay(ITransaction transaction) {
        System.out.println("Payment processed via Card for transaction: " + transaction.getTransactionId());
        transaction.setStatus("Payment Confirmed");
    }
}