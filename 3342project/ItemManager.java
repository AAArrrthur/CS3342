import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ItemManager {
    private Map<String, Item> items;

    public ItemManager() {
        this.items = new HashMap<>();
    }

    public void createItem(Item item) {
        if (!items.containsKey(item.getItemId())) {
            items.put(item.getItemId(), item);
            System.out.println("Item created successfully.");
        } else {
            System.out.println("Item ID already exists.");
        }
    }

    public List<Item> searchItems(String keyword) {
        List<Item> results = new ArrayList<>();
        for (Item item : items.values()) {
            if (item.getTitle().contains(keyword) || item.getDescription().contains(keyword)) {
                results.add(item);
            }
        }
        return results;
    }

    public Item getItemById(String itemId) {
        return items.get(itemId);
    }

    public void updateItem(Item item) {
        if (items.containsKey(item.getItemId())) {
            items.put(item.getItemId(), item);
            System.out.println("Item updated successfully.");
        } else {
            System.out.println("Item does not exist.");
        }
    }

    public void deleteItem(String itemId) {
        if (items.containsKey(itemId)) {
            items.remove(itemId);
            System.out.println("Item deleted successfully.");
        } else {
            System.out.println("Item does not exist.");
        }
    }
}