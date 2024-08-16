import java.util.HashMap;

public class CommandRegistery {
    private HashMap<String, ICommand> commands;
    private World world;
    private Avatar avatar;

    public CommandRegistery() {
            this.world = World.getInstance();
            this.avatar = Avatar.getInstance();
            commands = new HashMap<>();
            //To add all the commands directly after the World and Avatar are created
            addCommands();
    }

    public void addCommands() {
        commands.put("help", new HelpCommand(this));
        commands.put("map", new MapCommand());
        commands.put("move", new MoveCommand());
        commands.put("exit", new ExitCommand());
        commands.put("look", new LookCommand());
        commands.put("backpack", new BackpackCommand());
        commands.put("inspect", new InspectCommand());
        commands.put("take", new TakeCommand());
        commands.put("use", new UseCommand());
        commands.put("size", new SizeCommand());
        commands.put("write", new WriteCommand());
    }

    public ICommand getCommand(String commandName) {
        String temp=commandName.toLowerCase();
        return commands.get(temp);
    }

    public HashMap<String, ICommand> getAllCommands() {
        return commands;
    }
}

