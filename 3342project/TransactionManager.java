import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class TransactionManager {
    private Map<String, Transaction> transactions; // 声明为private

    public TransactionManager() {
        this.transactions = new HashMap<>();
    }

    public void createTransaction(Transaction transaction) {
        if (!transactions.containsKey(transaction.getTransactionId())) {
            transactions.put(transaction.getTransactionId(), transaction);
            System.out.println("Transaction created successfully.");
        } else {
            System.out.println("Transaction ID already exists.");
        }
    }

    public Transaction getTransactionById(String transactionId) {
        return transactions.get(transactionId);
    }

    public void confirmPayment(String transactionId, PaymentStrategy paymentStrategy) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction != null) {
            paymentStrategy.pay(transaction);
        } else {
            System.out.println("Transaction does not exist.");
        }
    }

    public void shipItem(String transactionId, String shippingMethod) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction != null) {
            transaction.setShippingMethod(shippingMethod);
            transaction.setStatus("Shipped");
            System.out.println("Item shipped for transaction: " + transactionId);
        } else {
            System.out.println("Transaction does not exist.");
        }
    }

    public void receiveItem(String transactionId) {
        Transaction transaction = transactions.get(transactionId);
        if (transaction != null) {
            transaction.setStatus("Completed");
            System.out.println("Item received for transaction: " + transactionId);
        } else {
            System.out.println("Transaction does not exist.");
        }
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions.values());
    }

    // 添加一个方法用于管理员监控交易，返回 List<ITransaction>
    public List<ITransaction> getTransactionsAsITransactionList() {
        List<ITransaction> result = new ArrayList<>();
        for (Transaction transaction : transactions.values()) {
            result.add(transaction);
        }
        return result;
    }
}