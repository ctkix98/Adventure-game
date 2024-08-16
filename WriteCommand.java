import java.util.ArrayList;

public class WriteCommand implements ICommand {
    @Override
    public String getDescription() {
        return "write your answer on a typewriter | write [an answer]";
    }

    @Override
    public String getName() {
        return "use";
    }

    @Override
    public void execute(String[] args) {
        String answer = null;
        ArrayList<Item> itemsOfThisLocation = null;
        Typewriter typewriterFound = null;

        if (args.length == 1) {
            if (args[0] != null){
                answer = args[0];
                itemsOfThisLocation = ItemManager.getInstance().getItemsListForOneLocation();
                if (itemsOfThisLocation != null) {
                    for (Item item : itemsOfThisLocation) {
                        if (item instanceof Typewriter) {
                            typewriterFound = (Typewriter) item;
                        }
                    }
                    if (typewriterFound != null){
                        typewriterFound.sendOrNotReward(answer);
                    } else {
                        System.out.println("There's no Typewriter in here, go check other locations.");
                    }
                } else {
                    System.out.println("There's no Typewriter in here, go check other locations.");
                }
            } else {
                System.out.println("You must write an one-word answer.");
            }
        } else {
            System.out.println("You must write an one-word answer.");
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return false;
    }
}
