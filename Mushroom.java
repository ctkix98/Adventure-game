public class Mushroom extends Item implements IInspectable {

    public Mushroom(String name, String description){
        super(name, description);
    }
    public String[] inspect() {
        String[] inspectionResult = new String[]{getName()+ "\n"+ getDescription()};
        return inspectionResult;
    }
}
