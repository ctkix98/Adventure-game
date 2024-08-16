public interface ICommand {
    String getDescription();
    String getName();
    void execute(String [] args);
    boolean hasValidArguments(String [] args);
    }

