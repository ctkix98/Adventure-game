import java.util.ArrayList;

public class BackpackCommand implements ICommand {
    private ArrayList<Item> backpackContent;

    public BackpackCommand() {
        backpackContent = Backpack.getInstance().getContent();
    }

    @Override
    public String getDescription() {
        return "display the content in your backpack";
    }

    @Override
    public String getName() {
        return "command";
    }

    @Override
    public void execute(String[] args) {
        if (args.length!=0){
            System.out.println("Don't put any argument");}
        else {
        if (backpackContent.isEmpty()) {
            System.out.println("Backpack is empty");
        } else {
            System.out.println(ListFormatter.formatList(backpackContent));
        }
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return true;
    }
}



