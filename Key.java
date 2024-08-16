import java.util.ArrayList;

public class Key extends Item implements IUseable, ITakeable, IInspectable {
    private final int ID;

    public Key(String name, String description, int ID) {

        super(name, description);
        this.ID = ID;
    }

    @Override
    public String[] inspect() {
        String [] inspectionresult =new String [] {getName()+ "\n"+ getDescription()};
        return inspectionresult;
    }

    @Override
    public void take() {

    }

    @Override
    public boolean use() {
        boolean used = false;
        //check if there's a location to unlock next to the Avatar
        ArrayList<Location> locations = new ArrayList<>();
        if (World.getInstance().isValidLocation(Avatar.getInstance().getRow()+1,  Avatar.getInstance().getColumn())) {
            locations.add(World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow()+1, Avatar.getInstance().getColumn()));
        }
        if (World.getInstance().isValidLocation(Avatar.getInstance().getRow()-1,Avatar.getInstance().getColumn())) {
            locations.add(World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow()-1, Avatar.getInstance().getColumn()));
        }
        if (World.getInstance().isValidLocation(Avatar.getInstance().getRow(),  Avatar.getInstance().getColumn()+1)) {
            locations.add(World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow(), Avatar.getInstance().getColumn()+1));
        }
        if (World.getInstance().isValidLocation(Avatar.getInstance().getRow(),  Avatar.getInstance().getColumn()-1)) {
            locations.add(World.getInstance().getLocationByCoordinates(Avatar.getInstance().getRow(), Avatar.getInstance().getColumn()-1));
        }

        for (Location location : locations) {
            if (location != null && location.isLocked() && location.LOCATION_ID == this.ID) {
                location.changeLockedState();
                used =!used;
            }
        }
        return used;
    }
}
