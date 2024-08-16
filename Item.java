public abstract class Item {
    private String name;
    private String description;



    public Item(String name, String description) {
        if (name != null && description != null) {
            this.name = name;
            this.description = description;
        } else {
            throw new RuntimeException("Please give a name and a description.");
        }
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "- "+this.name +"\n"+
                this.description + "\n";
    }
}
