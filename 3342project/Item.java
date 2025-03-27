
public class Item {
    private String itemId;
    private String title;
    private String description;
    private double price;
    private String sellerId;
    private boolean isAvailable;

    public Item(String itemId, String title, String description, double price, String sellerId) {
        this.itemId = itemId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.sellerId = sellerId;
        this.isAvailable = true;
    }

    // Getter和Setter方法
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getSellerId() {
        return sellerId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}