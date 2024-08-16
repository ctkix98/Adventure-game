public class LookCommand implements ICommand {

    private World world;

    public LookCommand() {
        this.world = World.getInstance();
    }

    @Override
    public String getDescription() {
        return "look the world around you";
    }

    @Override
    public String getName() {
        return "look [an object]";
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            System.out.println("Don't put any argument");
        } else if (ItemManager.getInstance().getItemsListForOneLocation().isEmpty()) {
            System.out.println("This zone is empty now");
        } else {
            System.out.println(ListFormatter.formatList(ItemManager.getInstance().getItemsListForOneLocation()));
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return true;
    }
}
