public class Potion extends Item implements IUseable, ITakeable {
    private boolean isEmpty;

    public Potion(String name, String description) {
        super(name, description);
        isEmpty = false;
    }

    public boolean use() {
        boolean used = false;
        if (!isEmpty) {
            isEmpty = true;
            Avatar.getInstance().changeSize();
            used = !used;
            System.out.println("Potion has been drunk");
            System.out.println();
            ItemManager.getInstance().removeItemFromLocation(this, Avatar.getInstance().getLocation());
            if (Avatar.getInstance().getSize() != 5) {
                System.out.println("Your size is now " + Avatar.getInstance().getSize()+"\n");
            }
        } else {
            System.out.println("Potion is empty");
        }
        return used;
    }

    @Override
    public void take() {

    }
}
