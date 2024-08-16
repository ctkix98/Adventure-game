public class SizeCommand implements ICommand {
    @Override
    public String getDescription() {
        return "give the size";
    }

    @Override
    public String getName() {
        return "size";
    }

    @Override
    public void execute(String[] args) {
       if (args.length != 0) {
            System.out.println("Don't put any argument");
        } else {
            System.out.println(Avatar.getInstance().getSize() + "/5");
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return false;
    }
}
