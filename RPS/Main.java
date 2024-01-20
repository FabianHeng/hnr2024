public class Main {
    public static Bot bot1 = new Randy();
    public static Bot bot2 = new RolyPoly();
    public static int draw = 0;
    public static int bot1Points = 0;
    public static int bot2Points = 0;

    public static void rounds(Bot bot1, Bot bot2) {
        String bot1Choice = bot1.choice();
        String bot2Choice = bot2.choice();
        if (bot1Choice == "scissors") {
            switch (bot2Choice) {
                case "rock":
                    bot2Points++;
                    break;
                case "paper":
                    bot1Points++;
                    break;
                case "scissors":
                    draw++;
                    break;
            }
        } else if (bot1Choice == "paper") {
            switch (bot2Choice) {
                case "scissors":
                    bot2Points++;
                    break;
                case "rock":
                    bot1Points++;
                    break;
                case "paper":
                    draw++;
                    break;
            }
        } else if (bot1Choice == "rock") {
            switch (bot2Choice) {
                case "paper":
                    bot2Points++;
                    break;
                case "scissors":
                    bot1Points++;
                    break;
                case "rock":
                    draw++;
                    break;
            }
        }
        bot1.update(bot2Choice);
        bot2.update(bot1Choice);
    }

    public static void main(String[] args){
		for (int i = 0; i < 200; i++) {
            rounds(bot1, bot2);
            // System.out.println("round " + i + " bot1: " + bot1.choice() + " | bot2: " + bot2.choice());
        }
        System.out.println("Bot 1 won " + bot1Points + " rounds.");
        System.out.println("Bot 2 won " + bot2Points + " rounds.");
        System.out.println("Both bots drawn " + draw + " rounds.");
        System.out.println(bot2Points/2 + "%");
	}
}