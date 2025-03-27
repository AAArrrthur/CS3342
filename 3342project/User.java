public class User implements IUser {
    private String userId;
    private String password;
    private String role; // "buyer", "seller", "both"
    private double creditScore;

    public User(String userId, String password, String role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.creditScore = 100.0; // 初始信用分
    }

    // Getter和Setter方法
    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public double getCreditScore() {
        return creditScore;
    }

    @Override
    public void updateCreditScore(double score) {
        this.creditScore = score;
    }
}