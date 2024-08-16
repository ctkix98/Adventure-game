import java.util.HashSet;


public class MoveCommand implements ICommand {
    private final World WORLD;
    private final Avatar AVATAR;
    private HashSet<String> validDirections;

    public MoveCommand() {
        this.WORLD = World.getInstance();
        this.AVATAR = Avatar.getInstance();
        this.validDirections = new HashSet<>();
        fillHashset();
    }

    @Override
    public String getDescription() {
        return "move | move [north, south, east, west]";
    }

    @Override
    public String getName() {
        return "MoveCommand";
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {

            if (hasValidArguments(args)) {
                move(args);
            } else {
                System.out.println(args[0] + " is not a direction");
            }
        } else {
            System.out.println("You forget to add a direction : [north, south, east, west]");
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        for (String argument : args) {
            if (this.validDirections.contains(argument)) {
                return true;
            }
        }
        return false;
    }

    private void fillHashset() {
        this.validDirections.add("north");
        this.validDirections.add("south");
        this.validDirections.add("east");
        this.validDirections.add("west");
    }

    private boolean move(String[] args) {
        boolean playerMoved = false;
        String direction = args[0].toLowerCase();
        int newRowAvatar = AVATAR.getRow();
        int newColAvatar = AVATAR.getColumn();

        switch (direction) {
            case "north":
                newRowAvatar -= 1;
                break;
            case "south":
                newRowAvatar += 1;
                break;
            case "east":
                newColAvatar += 1;
                break;
            case "west":
                newColAvatar -= 1;
                break;
            default:
                System.out.println("Invalid direction");
                return false;
        }
        //check if the player can move to the direction given (unlock and not out of bounds)
        if (newRowAvatar >= 0 && newRowAvatar <= WORLD.getMap()[0].length-1 && newColAvatar >= 0 && newColAvatar <= WORLD.getMap().length-1) {
            if (!WORLD.getLocationByCoordinates(newRowAvatar, newColAvatar).isLocked()) {
                AVATAR.setLocation(WORLD.getLocationByCoordinates(newRowAvatar, newColAvatar));
                System.out.println("You're going " + direction+", you're now at "+Avatar.getInstance().getPositionName());

                playerMoved = true;
            } else {
                System.out.println("This zone is locked");
            }
        } else {
            System.out.println("Don't go out of bounds");
        }
        return playerMoved;
    }

    public HashSet<String> getDirections() {
        return this.validDirections;
    }
}
