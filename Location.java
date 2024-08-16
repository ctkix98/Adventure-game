public class Location {
    public static int ID = 1;
    private final String name;
    private final String description;
    private boolean isLocked;
    public final int LOCATION_ID;

    public Location(String name, String description, boolean isLocked) {
        if (name != null && description != null) {
            this.name = name;
            this.description = description;
            this.isLocked = isLocked;
            this.LOCATION_ID = Location.ID++;
        } else {
            throw new RuntimeException("There is a problem Huston");
        }

    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void changeLockedState() {
        isLocked = !isLocked;
        System.out.println(isLocked ? (this.getName() + " is now locked") : this.getName() + " is now unlocked");
    }
}
