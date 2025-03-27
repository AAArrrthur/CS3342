import java.util.ArrayList;
import java.util.List;

public class AdminManager implements IAdmin {
    private UserManager userManager;
    private TransactionManager transactionManager;

    public AdminManager(UserManager userManager, TransactionManager transactionManager) {
        this.userManager = userManager;
        this.transactionManager = transactionManager;
    }

    @Override
    public List<ITransaction> monitorTransactions() {
        return transactionManager.getTransactionsAsITransactionList();
    }

    @Override
    public void banUser(String userId) {
        IUser user = userManager.getUserById(userId);
        if (user != null) {
            user.updateCreditScore(0.0);
            System.out.println("User " + userId + " has been banned.");
        } else {
            System.out.println("User does not exist.");
        }
    }

    @Override
    public void updateSystem() {
        System.out.println("System updated successfully.");
    }
}