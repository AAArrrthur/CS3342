import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, IUser> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public void registerUser(IUser user) {
        if (!users.containsKey(user.getUserId())) {
            users.put(user.getUserId(), user);
            System.out.println("User registered successfully.");
        } else {
            System.out.println("User already exists.");
        }
    }

    public IUser loginUser(String userId, String password) {
        if (users.containsKey(userId)) {
            IUser user = users.get(userId);
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("User does not exist.");
        }
        return null;
    }

    public IUser getUserById(String userId) {
        return users.get(userId);
    }
}