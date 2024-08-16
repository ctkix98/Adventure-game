import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in)
                .useLocale(new Locale.Builder()
                        .setLanguage("CH")
                        .setRegion("fr")
                        .build());

        String inputUser = "";
        boolean gameFinished = false;

       do {
           Game monJeu = Game.getInstance();
           System.out.print("> ");
           inputUser =scanner.nextLine().toLowerCase().trim();
           String [] tokens = inputUser.split("\\s");
           String commandName = tokens[0];
           ICommand command = Game.getInstance().commandRegistery.getCommand(commandName);
           String [] commandArgs = Arrays.copyOfRange(tokens,1, tokens.length);
           if (command!=null) {
               command.execute(commandArgs);
               gameFinished = Game.getInstance().victoryStatement();
               if (gameFinished){
                   System.out.println("You're tired but triumphant. You've defeated Gaborus Sorcierus and overcome all the trials the enchanted garden has imposed on you. \n"+
                           "You take a deep breath, enjoying the sight of your garden back to normal. You're free at last, ready to face new challenges, but this time at your full size. \n"+ "" +
                           "Congratulations, you've completed the game!\n");
                   break;
               }
           }else {
               System.out.println("Command not valid, try again");
               System.out.println("Type help to know all the commands");
           }
               }while (!inputUser.equals("exit") || gameFinished);
    }
}
