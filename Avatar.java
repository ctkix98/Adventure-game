public class Avatar {
    private static Avatar instance;
    private Location location;
    private String name;
    private Backpack inventory;
    private int size;

    private Avatar() {

        this.location = World.getInstance().getLocationByName("The 57th Street");
        this.name = "Mr. P";
        this.inventory = Backpack.getInstance();
        this.size = 0;
    }

    public static Avatar getInstance() {
        if (instance == null) {
            instance = new Avatar();
        }
        return instance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    //Needed to compare Avatar's position with Location's position
    public int getRow() {
        int row = 0;
        row = World.getInstance().getLocationRow(this.getLocation());
        return row;
    }

    public int getColumn() {
        int column = 0;
        column = World.getInstance().getLocationColumn(this.getLocation());
        return column;
    }

    public String getPositionName() {
        return this.location.getName();
    }

    public Location[] getLocationsAround() {
        Location[] table = {
                World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow() + 1, Avatar.getInstance().getColumn()),
                World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow() - 1, Avatar.getInstance().getColumn()),
                World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow(), Avatar.getInstance().getColumn() + 1),
                World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow(), Avatar.getInstance().getColumn() - 1)
        };
        return table;
    }

    public int getSize() {
        return this.size;
    }

    public void changeSize() {
        this.size++;
    }
}
