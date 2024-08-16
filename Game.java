public class Game {

    private static Game instance;


    public final World WORLD;
    public final Avatar AVATAR;
    public final CommandRegistery commandRegistery;

    private Game() {
        WORLD = World.getInstance();
        AVATAR = Avatar.getInstance();

        //System.out.println("Initializing World");
        initializeLocations();
        System.out.println("World Initialized");

        //System.out.println("Initializing Player");
        //To set the location of the Avatar, creating the avatar directly at the location 0, 0
        AVATAR.setLocation(this.WORLD.getLocationByCoordinates(0, 0));
        System.out.println("Player Initialized");

        //System.out.println("Initializing Commands");
        //To create the new registerCommand, linked to this World
        commandRegistery = initializeCommands();
        System.out.println("Commands Initialized");

        //System.out.println("Initializing Items");
        initializeItems();
        System.out.println("Items Initialized\n\n");


        //Set description when the game starts
        System.out.println("WELCOME IN THE GAME");
        System.out.println("You come home after a tough day at HEIG, and you encounter Gaborus Sorcierus. The wizard, furious that you submitted your assignments on Sunday at 12:05 PM, condemns you to become a tiny person.\n" +
        "You suddenly find yourself reduced to the size of an ant, lost in the midst of your immense fairy garden.\n"+
                "The brightly colored plants now seem like giant trees, and the insects flying over them resemble dragons.\n" +
        "Determined to return to your normal size, you set out to find a way to counter Gaborus Sorcierus's spell.\n" +
                "Through this world full of dangers, you will need to solve puzzles to unlock all areas of the map and obtain all the potions that will allow you to regain your size.");

        System.out.println();
        System.out.println("You are here : " + Avatar.getInstance().getPositionName());
        System.out.println(Avatar.getInstance().getLocation().getDescription());
        System.out.println("If you need a little help, you can write 'help'");


    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public CommandRegistery getCommandRegistery() {
        return commandRegistery;
    }

    public boolean victoryStatement() {
        boolean endGame = false;
        if (Avatar.getInstance().getSize() == 5) {
            endGame = true;
            System.out.println("You're back to your normal size !\n");
        }
        return endGame;
    }


    private void initializeLocations() {
        WORLD.addLocations(new Location("Forest of Giant Flowers", "A zone filled with gigantic flowers with colorful petals, housing astonishing creatures.", false), 0, 0);
        WORLD.addLocations(new Location("Meadow of Whispering Grasses", "A meadow where the grasses whisper secrets as the wind passes.", false), 0, 1);
        WORLD.addLocations(new Location("Cave of Brilliant Fireflies", "A cave illuminated by thousands of fireflies, creating a magical spectacle.", false), 0, 2);
        WORLD.addLocations(new Location("Marsh of Enchanted Water Lilies", "A marsh filled with magical water lilies where wise frogs offer advice.", false), 0, 3);
        WORLD.addLocations(new Location("Temple of Praying Mantises", "An ancient temple protected by wise and powerful praying mantises.", false), 1, 0);
        WORLD.addLocations(new Location("River of Dragonfly Nymphs", "A river lined with water lilies and shimmering dragonflies.", true), 1, 1);
        WORLD.addLocations(new Location("Orchard of Giant Fruit", "An orchard where immense fruits grow. Some fruits have magical properties, and Monsieur P. must harvest them while avoiding protective insects.", false), 1, 2);
        WORLD.addLocations(new Location("Glade of Mystical Orchids", "An enchanted glade where orchids with magical properties grow.", true), 1, 3);
        WORLD.addLocations(new Location("Wild Rose Garden", "A garden filled with wild roses with formidable thorns.", false), 2, 0);
        WORLD.addLocations(new Location("Labyrinth of Tangled Liana", "A maze of liana and climbing plants, moving slowly and continually changing the path to follow. Some are poisonous and must be avoided.", true), 2, 1);
        WORLD.addLocations(new Location("Shores of the Mirroring Lake", "The shores of a lake with waters so calm they reflect the sky like a mirror. The reflections can reveal hidden secrets underwater or in the skies.", false), 2, 2);
        WORLD.addLocations(new Location("Caves of Luminescent Sap", "Caves where tree sap glows with a bluish light. The sap is sticky and can slow movements, but it also illuminates the path ahead.", true), 2, 3);
        WORLD.addLocations(new Location("Desert of Giant Cacti", "A vast arid expanse populated by giant cacti. These cacti store precious water and can burst open when needed, but they also harbor venomous creatures.", false), 3, 0);
        WORLD.addLocations(new Location("Waterfall of Crystal Mist", "A tall waterfall where sparkling water flows. Suspended droplets create rainbows and illusions. Some passages are visible only through these illusions.", false), 3, 1);
        WORLD.addLocations(new Location("Grove of Golden Leaves", "A grove where tree leaves are golden and shimmer in the sunlight. These leaves can be used for potions and remedies, but they also attract greedy creatures.", true), 3, 2);
        WORLD.addLocations(new Location("Floating Petals Islands", "Floating islands in the air, held up by giant petals. Monsieur P. must jump from petal to petal to advance while avoiding strong winds.", true), 3, 3);

        System.out.println("Locations Initialized");
    }

    private CommandRegistery initializeCommands() {
        return new CommandRegistery();
    }

    private void initializeItems() {
        //Initialize Letters
        ItemManager.getInstance().addItemToLocation(new Letter("Golden Letter",
                "mysterious letter",
                "Keep this golden letter very carefully, it will help you open the last location and find the final potion that will give you your size back.\n" +
                        "Someone is watching you right now, guess who he is. He left you some clues :\n" +
                        "My first part is made of milk and spread on bread.\n" +
                        "My second part is my way of moving."), World.getInstance().getLocationByCoordinates(0, 0));
        ItemManager.getInstance().addItemToLocation(new Letter("Green Letter",
                "mysterious letter",
                "I am pretty and sweet-scented,\n" +
                        "Often given as a token of love.\n" +
                        "But beware of my thorns,\n" +
                        "For I can also prick.\n" +
                        "What am I?"), World.getInstance().getLocationByCoordinates(1, 0));
        ItemManager.getInstance().addItemToLocation(new Letter("Purple Letter",
                "mysterious letter",
                "Fireflies are nice but tricky, you need to find the password if you want them to light up your path.\n" +
                        "Here is a clue : fire/star/moon/sun/torch"), World.getInstance().getLocationByCoordinates(0, 2));
        ItemManager.getInstance().addItemToLocation(new Letter("Turquoise Letter",
                "mysterious letter",
                "I am a tree and a fruit joined together to form another fruit"), World.getInstance().getLocationByCoordinates(0, 3));
        ItemManager.getInstance().addItemToLocation(new Letter("White Letter",
                "mysterious letter",
                "You're stuck inside the liana ? \n" +
                        "Don't worry, Jimmy the Monkey will help you but first he wants you to help him with this math problem :\n" +
                        "I am a number with two figures. The sum of my two figures is 10. If you invert my figures, the new number is 36 less than me.\n" +
                        "Which number am I ?"), World.getInstance().getLocationByCoordinates(2, 2));
        ItemManager.getInstance().addItemToLocation(new Letter("Crimson Letter",
                "mysterious letter",
                "I'm a vast, chilly country\n" +
                        "Where a very special tree\n" +
                        "Generously gives its sap\n" +
                        "For a bronze sweet sirup\n" +
                        "Who am I?"), World.getInstance().getLocationByCoordinates(3, 1));

        //Initialize Typewriters and Keys
        //new position : 2/0 ID 3, key given :2/1
        ItemManager.getInstance().addItemToLocation(
                new Typewriter.TypewriterBuilder("Rosy", "a typewriter to give your answer", World.getInstance().getLocationByCoordinates(2, 0), "rose")
                        .withReward(new Key("Liana Key", "key to open the Labyrith of Tangled Liana",
                                World.getInstance().getLocationByCoordinates(2, 1).LOCATION_ID)).build(),
                World.getInstance().getLocationByCoordinates(2, 0));

        //new position : 0/2 ID 9, key given : 1/1
        ItemManager.getInstance().addItemToLocation(
                new Typewriter.TypewriterBuilder("Brighty", "a typewriter to give your answer", World.getInstance().getLocationByCoordinates(0, 2), "light")
                        .withReward(new Key("Dragonfly Key", "key to open the River of Dragonfly Nymphs",
                                World.getInstance().getLocationByCoordinates(1, 1).LOCATION_ID)).build(),
                World.getInstance().getLocationByCoordinates(0, 2));

        //new position : 1/2, ID 7, key given : 1/3
        ItemManager.getInstance().addItemToLocation(
                new Typewriter.TypewriterBuilder("Cherry", "a typewriter to give your answer", World.getInstance().getLocationByCoordinates(1, 2), "pineapple")
                        .withReward(new Key("Orchids Key", "key to open the Glade of Mystical Orchids",
                                World.getInstance().getLocationByCoordinates(1, 3).LOCATION_ID)).build(),
                World.getInstance().getLocationByCoordinates(1, 2));

        //new position : 2/1 ID 10, key given : 2/3
        ItemManager.getInstance().addItemToLocation(
                new Typewriter.TypewriterBuilder("Lily", "a typewriter to give your answer", World.getInstance().getLocationByCoordinates(2, 1), "73")
                        .withReward(new Key("Sap Key", "key to open the Caves of Luminescent Sap",
                                World.getInstance().getLocationByCoordinates(2, 3).LOCATION_ID)).build(),
                World.getInstance().getLocationByCoordinates(2, 1));

        //new position : 2/3 ID 8; key given 3/2
        ItemManager.getInstance().addItemToLocation(
                new Typewriter.TypewriterBuilder("Sapy", "a typewriter to give your answer", World.getInstance().getLocationByCoordinates(2, 3), "canada")
                        .withReward(new Key("Golden Leaves Key", "key to open the Grove of Golden Leaves",
                                World.getInstance().getLocationByCoordinates(3, 2).LOCATION_ID)).build(),
                World.getInstance().getLocationByCoordinates(2, 3));

        //new position 3/2 ID 15, key given : 3/3
        ItemManager.getInstance().addItemToLocation(
                new Typewriter.TypewriterBuilder("Goldy", "a typewriter to give your answer", World.getInstance().getLocationByCoordinates(3, 2), "butterfly")
                        .withReward(new Key("Petals Key", "key to open the Floating Petals Islands",
                                World.getInstance().getLocationByCoordinates(3, 3).LOCATION_ID)).build(),
                World.getInstance().getLocationByCoordinates(3, 2));


        //Initialize Potions
        ItemManager.getInstance().addItemToLocation(new Potion("Shiny Nectar", "Drink me, I'll make you grow !"), World.getInstance().getLocationByCoordinates(1, 1));
        ItemManager.getInstance().addItemToLocation(new Potion("Prickly Cocktail", "Drink me, I'll make you grow !"), World.getInstance().getLocationByCoordinates(3, 0));
        ItemManager.getInstance().addItemToLocation(new Potion("Mystic Mixture", "Drink me, I'll make you grow !"), World.getInstance().getLocationByCoordinates(1, 3));
        ItemManager.getInstance().addItemToLocation(new Potion("Ivy Serum", "Drink me, I'll make you grow !"), World.getInstance().getLocationByCoordinates(2, 1));
        ItemManager.getInstance().addItemToLocation(new Potion("Blossom Elixir", "Drink me, I'll make you grow !"), World.getInstance().getLocationByCoordinates(3, 3));

        //Initialize Mushrooms
        ItemManager.getInstance().addItemToLocation(new Mushroom("Wise Mushroom", "I think the next key is nearby."), World.getInstance().getLocationByCoordinates(0,1));
        ItemManager.getInstance().addItemToLocation(new Mushroom("Confident Mushroom", "You're lost ? Maybe you should find some butterflies to help you with..."),World.getInstance().getLocationByCoordinates(2,1));
    }



}
