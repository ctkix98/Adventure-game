public class Letter extends Item implements IInspectable, ITakeable{
    private String content;

    public Letter(String name, String description, String content) {
        super(name, description);
        this.content = content;
    }

    public String[] inspect() {
        String[] inspectionResult = new String[]{getName()+ "\n"+ this.content};
        return inspectionResult;
    }

    @Override
    public void take() {

    }
}
