public class UseCommand implements ICommand {
    @Override
    public String getDescription() {
        return "use an item in your inventory or in the location | use [an object]";
    }

    @Override
    public String getName() {
        return "use ";
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            if (args.length > 1) {
                String arg = String.join(" ", args).trim();
                toUse(arg);
            } else if (args.length == 1) {
                String arg = args[0].trim();
                toUse(arg);
            }
        } else {
            System.out.println("you forget to write what you want to use");
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return false;
    }

    private boolean containedInLocation(String args) {
        return ItemManager.getInstance().getItemsListForOneLocation().stream().filter(item -> item.getName().equalsIgnoreCase(args)).findFirst().orElse(null) != null;
    }

    private boolean containedInBackpack(String args) {
        return Backpack.getInstance().getContent().stream().filter(item -> item.getName().equalsIgnoreCase(args)).findFirst().orElse(null) != null;
    }

    public void toUse(String arg) {
        boolean itemFound = false;
        if (containedInLocation(arg)) {
            //check if the item is in the location
            for (Item item : ItemManager.getInstance().getItemsListForOneLocation()) {
                if (item.getName().equalsIgnoreCase(arg)) {
                    itemFound = true;
                    if (item instanceof IUseable) {
                        System.out.println("You need to take the item before using it");
                        break;
                    } else {
                        System.out.println("You can't use " + arg);
                    }
                }
            }

        }//check if the item is in the backpack
        else if (containedInBackpack(arg)) {
            for (Item item : Backpack.getInstance().getContent()) {
                if (item.getName().equalsIgnoreCase(arg)) {
                    itemFound = true;
                    if (item instanceof IUseable useableItem) {
                        if (useableItem.use()){
                            Backpack.getInstance().getContent().remove(useableItem);
                            break;
                        } else {
                            System.out.println(arg + " can't be used here, go next to zone you want to open");
                        }
                    } else {
                        System.out.println("You can't use " + arg);
                    }
                }
            }
        } //check if it's neither in location nor backpack
        else if (!containedInBackpack(arg) && !containedInLocation(arg)) {
            itemFound = false;
            System.out.println(arg + " is not here");
        }
    }
}

