import java.util.ArrayList;

public class Backpack {
    private static Backpack instance;
    private ArrayList<Item> content;


    private Backpack() {
        this.content = new ArrayList<>();
    }

    public static Backpack getInstance() {
        if (instance == null) {
            instance = new Backpack();
        }
        return instance;
    }

    public ArrayList<Item> getContent() {
        return content;
    }

    public void addItem(Item itemToTake) {
        content.add(itemToTake);
    }

    // not done yet
    public Item removeItem(String itemDescription) {
        Item itemToRemove =null;
                //ItemManager.getInstance().getItemsRegistry().
        return itemToRemove;
    }

}

