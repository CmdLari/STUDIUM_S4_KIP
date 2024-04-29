public class Client {


    private static int maxBranches = 5;
    private static int complexity=4;
    private static int leavesNumber=20;
    private static int maxValue= 5;
    private static int minValue = 0;
    public static void main(String[] args) {
        Game game = new Game(maxBranches,complexity,leavesNumber,maxValue,minValue);
        System.out.println(game.play());
    }
}
