public class MapCommand implements ICommand {
    private World world;
    private Avatar avatar;
    private Location[][] map;
    private static final String RESET = "\033[0m";
    private static final String RED = "\033[0;31m";
    private static final String GREEN = "\033[0;32m";
    private static final String UNDERLINE = "\033[4m";
    private static final String UNDERLINE_RESET = "\033[24m";

    public MapCommand() {
        this.world = World.getInstance();
        this.avatar = Avatar.getInstance();
        this.map = world.getMap();
    }

    @Override
    public String getDescription() {
        return "show map";
    }

    @Override
    public String getName() {
        return "MapCommand";
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            System.out.println("Don't put any argument");
        } else {
            printAsciiMap();
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return false;
    }


    // For map command, any argument is valid since it doesn't need any. Hence, it always returns true.
    public boolean hasValidArgument(String arg) {
        return true;
    }

    // Executes the map command, which prints the ASCII map.
    public void execute(String arg) {
        printAsciiMap();
    }

    // Method to print the ASCII map.
    public void printAsciiMap() {
        int maxLength = findMaxLength();  // Find the maximum length of location names for alignment purposes.

        // Print each row of the map.
        for (int row = 0; row < map.length; row++) {
            printHorizontalLine(maxLength, map[row].length);  // Print the top horizontal line for each location.
            printLocationNames(row, maxLength);  // Print the names of locations in the row.
        }

        // Print the bottom horizontal line of the map.
        printHorizontalLine(maxLength, map[0].length);
    }

    // Method to print the horizontal line for each location in the map.
    private void printHorizontalLine(int maxLength, int numColumns) {
        for (int col = 0; col < numColumns; col++) {
            System.out.print("+");
            System.out.print("-".repeat(maxLength + 2));  // Print the horizontal line with length according to the maxLength.
        }
        System.out.println("+");
    }

    // Method to print the names of locations in a row.
    private void printLocationNames(int row, int maxLength) {
        for (int col = 0; col < map[row].length; col++) {
            Location location = map[row][col];
            String text;

            // If the location is not null, set the text as the name of the location, otherwise set it as a space.
            if (location != null) {
                text = location.getName();
            } else {
                text = " ";
            }

            int padding = (maxLength - text.length()) / 2;  // Calculate the padding for alignment purposes.
            String paddingSpaces = " ".repeat(padding + 1);  // Generate the padding spaces string.

            System.out.print("|");

            String color = "";
            // Determine the color based on whether the location is unlocked
            if (location != null && !location.isLocked()) {
                color = GREEN;
            } else {
                color = RED;
            }

            // If the current location is the player's location, underline it using ANSI escape codes.
            if (avatar.getRow() == row && avatar.getColumn() == col) {
                text = "[" + text + "]";
            }

            System.out.print(paddingSpaces);
            System.out.print(color + text + RESET);
            System.out.print(paddingSpaces);
        }
        System.out.println("|");
    }

    // This method is responsible for determining the maximum length of a location's name
    private int findMaxLength() {
        // We start by setting maxLength to 0
        int maxLength = 0;

        // We iterate over each row of locations in the map
        for (Location[] locations : map) {
            // For each row, we iterate over each location in that row
            for (Location location : locations) {
                // We only proceed if the location is not null
                if (location != null) {
                    // If the length of the current location's name is greater than maxLength,
                    // we update maxLength to be the length of the current location's name
                    maxLength = Math.max(maxLength, location.getName().length());
                }
            }
        }
        // After checking all locations, we return the maximum length found
        return maxLength;
    }
}


