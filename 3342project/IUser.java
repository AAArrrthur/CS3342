public interface IUser {
    String getUserId();
    String getPassword();
    void setPassword(String password);
    String getRole();
    double getCreditScore();
    void updateCreditScore(double score);
}