public class OctopusPayment implements PaymentStrategy {
    @Override
    public void pay(ITransaction transaction) {
        System.out.println("Payment processed via Octopus for transaction: " + transaction.getTransactionId());
        transaction.setStatus("Payment Confirmed");
    }
}
