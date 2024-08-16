public class Typewriter extends Item {
    private Location location;
    private String answer;
    private Item reward;



    private Typewriter(TypewriterBuilder builder) {
        super(builder.name, builder.description);
        this.location = builder.location;
        this.answer = builder.answer;
        this.reward = builder.reward;
    }

    public boolean isAnswerCorrect(String answer) {
        return answer.equalsIgnoreCase(this.answer);
    }

    public void sendOrNotReward(String answer) {
        if (isAnswerCorrect(answer)) {
            dropReward();
            System.out.println("Your answer is right, congrats ! Look around you. There's something new!");
            ItemManager.getInstance().removeItemFromLocation(this, this.location);
        } else {
            System.out.println("Sorry, wrong answer. Try again!");
        }
    }

    public void dropReward() {
        ItemManager.getInstance().addItemToLocation(this.reward, this.location);
    }

    //Builder
    public static class TypewriterBuilder {
        private String name;
        private String description;
        private Location location;
        private String answer;
        private Item reward = null;

        public TypewriterBuilder(String name, String description, Location location, String answer) {
            this.name = name;
            this.description = description;
            this.location = location;
            this.answer = answer;
        }

        public TypewriterBuilder withReward(Item rewardItem) {
            this.reward = rewardItem;
            return this;
        }

        public Typewriter build() {
            return new Typewriter(this);
        }
    }

}