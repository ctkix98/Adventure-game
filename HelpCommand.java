
import java.util.Map;

public class HelpCommand implements ICommand {
    private CommandRegistery CommandRegistery;

    public HelpCommand(CommandRegistery commandRegistery) {
        this.CommandRegistery = commandRegistery;
    }

    @Override
    public String getDescription() {
        return "describe all commands";
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(String[] args) {
        if (args.length!=0){
            System.out.println("Don't put any argument");}
        else {
            //For each to show all the commands in the CommandRegistery
            Map<String, ICommand> commands = this.CommandRegistery.getAllCommands();
            for (Map.Entry<String, ICommand> entry : commands.entrySet()) {
                System.out.println("Command : " + entry.getKey() + " | It is used to " + entry.getValue().getDescription());
            }
            System.out.println("Last but not least : the game is not case sensitive ! Feel free to put CAPS or not");
        }
    }

    @Override
    public boolean hasValidArguments(String[] args) {
        return true;
    }
}


