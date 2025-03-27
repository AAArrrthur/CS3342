import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 初始化管理系统
        UserManager userManager = new UserManager();
        ItemManager itemManager = new ItemManager();
        TransactionManager transactionManager = new TransactionManager();
        FeedbackManager feedbackManager = new FeedbackManager();
        AdminManager adminManager = new AdminManager(userManager, transactionManager);

        while (true) {
            System.out.println("\n===== Second-hand Exchange System =====");
            System.out.println("1. User Management");
            System.out.println("2. Item Management");
            System.out.println("3. Transaction Management");
            System.out.println("4. Feedback Management");
            System.out.println("5. Admin Management");
            System.out.println("6. Exit");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    userManagement(scanner, userManager);
                    break;
                case 2:
                    itemManagement(scanner, userManager, itemManager);
                    break;
                case 3:
                    transactionManagement(scanner, userManager, itemManager, transactionManager);
                    break;
                case 4:
                    feedbackManagement(scanner, userManager, feedbackManager);
                    break;
                case 5:
                    adminManagement(scanner, adminManager, userManager);
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void userManagement(Scanner scanner, UserManager userManager) {
        while (true) {
            System.out.println("\n===== User Management =====");
            System.out.println("1. Register User");
            System.out.println("2. Login User");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Please input user ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Please input password: ");
                    String password = scanner.nextLine();
                    System.out.print("Please input role (buyer/seller/admin): ");
                    String role = scanner.nextLine();
                    IUser user = UserFactory.createUser(userId, password, role);
                    userManager.registerUser(user);
                    break;
                case 2:
                    System.out.print("Please input user ID: ");
                    String loginUserId = scanner.nextLine();
                    System.out.print("Please input password: ");
                    String loginPassword = scanner.nextLine();
                    IUser loginUser = userManager.loginUser(loginUserId, loginPassword);
                    if (loginUser != null) {
                        System.out.println("Login successful. User ID: " + loginUser.getUserId());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void itemManagement(Scanner scanner, UserManager userManager, ItemManager itemManager) {
        while (true) {
            System.out.println("\n===== Item Management =====");
            System.out.println("1. Create Item");
            System.out.println("2. Search Items");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Back to Main Menu");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Please input item ID: ");
                    String itemId = scanner.nextLine();
                    System.out.print("Please input item title: ");
                    String title = scanner.nextLine();
                    System.out.print("Please input item description: ");
                    String description = scanner.nextLine();
                    System.out.print("Please input item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Please input seller ID: ");
                    String sellerId = scanner.nextLine();
                    Item item = new Item(itemId, title, description, price, sellerId);
                    itemManager.createItem(item);
                    break;
                case 2:
                    System.out.print("Please input search keyword: ");
                    String keyword = scanner.nextLine();
                    List<Item> searchResults = itemManager.searchItems(keyword);
                    System.out.println("Search results:");
                    for (Item item1 : searchResults) {
                        System.out.println("Item ID: " + item1.getItemId() + ", Title: " + item1.getTitle());
                    }
                    break;
                case 3:
                    System.out.print("Please input item ID to update: ");
                    String updateItemId = scanner.nextLine();
                    Item existingItem = itemManager.getItemById(updateItemId);
                    if (existingItem != null) {
                        System.out.print("Please input new title: ");
                        String newTitle = scanner.nextLine();
                        System.out.print("Please input new description: ");
                        String newDescription = scanner.nextLine();
                        System.out.print("Please input new price: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        Item updatedItem = new Item(existingItem.getItemId(), newTitle, newDescription, newPrice, existingItem.getSellerId());
                        itemManager.updateItem(updatedItem);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4:
                    System.out.print("Please input item ID to delete: ");
                    String deleteItemId = scanner.nextLine();
                    itemManager.deleteItem(deleteItemId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void transactionManagement(Scanner scanner, UserManager userManager, ItemManager itemManager, TransactionManager transactionManager) {
        while (true) {
            System.out.println("\n===== Transaction Management =====");
            System.out.println("1. Create Transaction");
            System.out.println("2. Confirm Payment");
            System.out.println("3. Ship Item");
            System.out.println("4. Receive Item");
            System.out.println("5. Back to Main Menu");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Please input transaction ID: ");
                    String transactionId = scanner.nextLine();
                    System.out.print("Please input buyer ID: ");
                    String buyerId = scanner.nextLine();
                    System.out.print("Please input seller ID: ");
                    String sellerId = scanner.nextLine();
                    System.out.print("Please input item ID: ");
                    String itemId = scanner.nextLine();
                    System.out.print("Please input amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    Transaction transaction = new Transaction(transactionId, buyerId, sellerId, itemId, amount);
                    transactionManager.createTransaction(transaction);
                    break;
                case 2:
                    System.out.print("Please input transaction ID to confirm payment: ");
                    String confirmTransactionId = scanner.nextLine();
                    System.out.print("Please input payment method (alipay/card/octopus): ");
                    String paymentMethod = scanner.nextLine();
                    PaymentStrategy paymentStrategy;
                    if (paymentMethod.equalsIgnoreCase("alipay")) {
                        paymentStrategy = new AlipayPayment();
                    } else if (paymentMethod.equalsIgnoreCase("card")) {
                        paymentStrategy = new CardPayment();
                    } else if (paymentMethod.equalsIgnoreCase("octopus")) {
                        paymentStrategy = new OctopusPayment();
                    } else {
                        System.out.println("Invalid payment method.");
                        continue;
                    }
                    transactionManager.confirmPayment(confirmTransactionId, paymentStrategy);
                    break;
                case 3:
                    System.out.print("Please input transaction ID to ship item: ");
                    String shipTransactionId = scanner.nextLine();
                    System.out.print("Please input shipping method: ");
                    String shippingMethod = scanner.nextLine();
                    transactionManager.shipItem(shipTransactionId, shippingMethod);
                    break;
                case 4:
                    System.out.print("Please input transaction ID to receive item: ");
                    String receiveTransactionId = scanner.nextLine();
                    transactionManager.receiveItem(receiveTransactionId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void feedbackManagement(Scanner scanner, UserManager userManager, FeedbackManager feedbackManager) {
        while (true) {
            System.out.println("\n===== Feedback Management =====");
            System.out.println("1. Create Feedback");
            System.out.println("2. View Feedbacks");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Please input feedback ID: ");
                    String feedbackId = scanner.nextLine();
                    System.out.print("Please input from user ID: ");
                    String fromUserId = scanner.nextLine();
                    System.out.print("Please input to user ID: ");
                    String toUserId = scanner.nextLine();
                    System.out.print("Please input rating (1-5): ");
                    double rating = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Please input comment: ");
                    String comment = scanner.nextLine();
                    Feedback feedback = new Feedback(feedbackId, fromUserId, toUserId, rating, comment);
                    feedbackManager.createFeedback(feedback);
                    break;
                case 2:
                    System.out.print("Please input user ID to view feedbacks: ");
                    String userId = scanner.nextLine();
                    List<Feedback> userFeedbacks = feedbackManager.getFeedbacksByUser(userId);
                    System.out.println("Feedbacks for user " + userId + ":");
                    for (Feedback feedback1 : userFeedbacks) {
                        System.out.println("Feedback ID: " + feedback1.getFeedbackId() + ", Rating: " + feedback1.getRating() + ", Comment: " + feedback1.getComment());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void adminManagement(Scanner scanner, AdminManager adminManager, UserManager userManager) {
        while (true) {
            System.out.println("\n===== Admin Management =====");
            System.out.println("1. Monitor Transactions");
            System.out.println("2. Ban User");
            System.out.println("3. Update System");
            System.out.println("4. Back to Main Menu");
            System.out.print("Please select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    List<ITransaction> monitoredTransactions = adminManager.monitorTransactions();
                    System.out.println("Monitored transactions:");
                    for (ITransaction transaction : monitoredTransactions) {
                        System.out.println("Transaction ID: " + transaction.getTransactionId() + ", Status: " + transaction.getStatus());
                    }
                    break;
                case 2:
                    System.out.print("Please input user ID to ban: ");
                    String userId = scanner.nextLine();
                    adminManager.banUser(userId);
                    break;
                case 3:
                    adminManager.updateSystem();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}