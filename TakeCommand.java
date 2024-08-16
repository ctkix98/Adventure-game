public class TakeCommand implements ICommand {
    @Override
    public String getDescription() {
        return "take an object in the location | take [an object]";
    }

    @Override
    public String getName() {
        return "take";
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            if (args.length > 1) {
                String arg = String.join(" ", args).trim();
                toTake(arg);

            } else if (args.length == 1) {
                String arg = args[0].trim();
                toTake(arg);
            }
        } else {
            System.out.println("You need to tell which item do you want to take !");
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return false;
    }

    public void toTake(String arg) {
        boolean itemFound = false;
        Item itemRemoved = null;
        //check if the item is on a location
        for (Item item : ItemManager.getInstance().getItemsListForOneLocation()) {
            if (item.getName().equalsIgnoreCase(arg)) {
                itemFound = true;
                if (item instanceof ITakeable) {
                    itemRemoved = item;
                    Backpack.getInstance().addItem(item);
                    break;
                }
            }
        }
        if (itemRemoved != null) {
            ItemManager.getInstance().removeItemFromLocation(itemRemoved, Avatar.getInstance().getLocation());
            System.out.println("You've taken " + itemRemoved.getName() + " from " +
                    World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow(),
                            Avatar.getInstance().getColumn()).getName());
        } else {
            if (!itemFound) {
                System.out.println("This item doesn't exist");
            } else {
                System.out.println("You can't take " + arg);
            }
        }
    }
}