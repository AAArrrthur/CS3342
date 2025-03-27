public class UserFactory {
    public static IUser createUser(String userId, String password, String role) {
        switch (role.toLowerCase()) {
            case "buyer":
                return new Buyer(userId, password);
            case "seller":
                return new Seller(userId, password);
            case "admin":
                return new Admin(userId, password);
            default:
                throw new IllegalArgumentException("Invalid user role");
        }
    }
}