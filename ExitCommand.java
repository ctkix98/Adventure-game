public class ExitCommand implements ICommand{
    private World world;
    private Avatar avatar;
    public ExitCommand () {
        this.avatar= Avatar.getInstance();
        this.world = World.getInstance();
    }
    @Override
    public String getDescription() {
        return "leave the game";
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute(String[] args) {
        if (args.length== 0){
            this.avatar = null;
            this.world = null;
        }else {
            System.out.println("Don't put any argument");
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return true;
    }
}
