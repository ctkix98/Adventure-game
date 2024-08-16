import java.util.HashMap;

public class World {
    private static World instance;
    private Location[][] map;
    private HashMap<String, Location> locations;
    private final int ROWS;
    private final int COLS;

    private World() {
        ROWS=4;
        COLS=4;
        map = new Location[ROWS][COLS];
        locations = new HashMap<>();
    }

    public static World getInstance() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }

    public void addLocations(Location location, int row, int col) {
        locations.put(location.getName(),location);
        map[row][col] = location;
    }

    public Location removeLocation(Location location) {
        return null;
    }

    public Location getLocationByName(String name) {
        Location location = null;
       if (locations.containsKey(name)){
           location = locations.get(name);
       }
        return location;
    }


    public Location getLocationByCoordinates(int row, int col) {
        return this.map[row][col];
    }

    public Location[][] getMap() {
        return this.map;
    }

    public int getLocationRow(Location location) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == location) {
                    return row;
                }
            }
        }
        return -1; // Return -1 if location is not found
    }

    public int getLocationColumn(Location location) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == location) {
                    return col;
                }
            }
        }
        return -1; // Return -1 if location is not found
    }

    public boolean isValidLocation(int row, int column) {
        return row >= 0 && row < ROWS && column >= 0 && column < COLS;
    }
}
