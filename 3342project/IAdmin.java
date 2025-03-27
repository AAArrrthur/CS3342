import java.util.List;
public interface IAdmin {
    List<ITransaction> monitorTransactions();
    void banUser(String userId);
    void updateSystem();
}