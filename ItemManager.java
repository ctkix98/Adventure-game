import java.util.ArrayList;
import java.util.HashMap;

public class ItemManager {
    private static ItemManager instance;
    private HashMap <Location, ArrayList<Item>> itemsRegistry;

    private ItemManager(){
        itemsRegistry = new HashMap<>();

    }

    public static ItemManager getInstance(){
        if (instance == null) {
            instance = new ItemManager();
        }
        return instance;
    }

    public HashMap<Location, ArrayList<Item>> getItemsRegistry() {
        return this.itemsRegistry;
    }

    public ArrayList<Item> getItemsListForOneLocation () {
        ArrayList <Item> liste = null;
        if (itemsRegistry.containsKey(Avatar.getInstance().getLocation())) {
         liste = itemsRegistry.get(Avatar.getInstance().getLocation());
        }
        return liste;
    }


    public void addItemToLocation(Item itemToAdd, Location locationWhereAdd){
        //checks if location is already in hashmap
        if (itemsRegistry.containsKey(locationWhereAdd)) {
            // if it exists, add the item in the list
            itemsRegistry.get(locationWhereAdd).add(itemToAdd);
        } else {
            // if it doesn't exist, create new Arraylist and add item in the registry
            ArrayList<Item> itemList = new ArrayList<>();
            itemList.add(itemToAdd);
            itemsRegistry.put(locationWhereAdd, itemList);
        }
    }

    public boolean removeItemFromLocation(Item item, Location location){
        return itemsRegistry.get(location).remove(item);
    }
}


