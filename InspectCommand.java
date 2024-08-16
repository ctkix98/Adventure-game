import java.util.Arrays;

public class InspectCommand implements ICommand {
    @Override
    public String getDescription() {
        return "inspect an item | inspect [an object]";
    }

    @Override
    public String getName() {
        return "inspect";
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            //if more than 1 args, we need to join them to pass in paramater to inspect
            if (args.length > 1) {
                String arg = String.join(" ", args).trim();
                Inspection(arg);

            } else if (args.length == 1) {
                String arg = args[0].trim();
                Inspection(arg);
            }
        } else {
            System.out.println("You need to tell which item do you want to inspect !");
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return false;
    }

    public void Inspection(String arg) {
        if (containedInLocation(arg)) {
            for (Item item : ItemManager.getInstance().getItemsListForOneLocation()) {
                if (item.getName().equalsIgnoreCase(arg)) {
                    if (item instanceof IInspectable inspectableItem) {
                        System.out.println(Arrays.toString(inspectableItem.inspect()));
                        break;
                    } else {
                        System.out.println("You can't inspect "+ arg);
                    }
                }
            }
        } else if (containedInBackpack(arg)) {
            for (Item item : Backpack.getInstance().getContent()) {
                if (item.getName().equalsIgnoreCase(arg)) {
                    if (item instanceof IInspectable inspectableItem) {
                        System.out.println(Arrays.toString(inspectableItem.inspect()));
                        break;
                    } else {
                        System.out.println("You can't inspect "+arg);
                    }
                }
            }
        } else if (!containedInBackpack(arg) && !containedInLocation(arg)) {
            System.out.println(arg + " is not here");
        }
    }

    private boolean containedInLocation(String args) {
        return ItemManager.getInstance().getItemsListForOneLocation().stream().filter(item -> item.getName().equalsIgnoreCase(args)).findFirst().orElse(null) != null;
    }

    private boolean containedInBackpack(String args) {
        return Backpack.getInstance().getContent().stream().filter(item -> item.getName().equalsIgnoreCase(args)).findFirst().orElse(null) != null;
    }
}
