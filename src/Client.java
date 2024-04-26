public class Client {

    private static int BOX_NUMBERS = 20;
    private static int MAX_VALUE = 10;
    private static int MIN_VALUE = 0;

    public static void main(String[] args) {
        Game game = new Game(BOX_NUMBERS, MAX_VALUE, MIN_VALUE);
        System.out.println(game.play());
    }
}
