import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private final int maxHouses = 4;
    private final int maxRooms = 14;
    private final List<Node> houses = new ArrayList<>();
    private final List<Node> rooms = new ArrayList<>();
    private final List<Node> boxes = new ArrayList<>();

    private final Node root;

    /**
     * create game Tree
     *
     * @param boxNumber nunmber of boxes (Leaves)
     * @param min       minimal value in a box
     * @param max       maximal value in a box
     */
    public Game(int boxNumber, int max, int min) {
        this.root = new Node();
        setGame(boxNumber, max, min);
    }

    private void setGame(int boxNumber, int max, int min) {
        Random rnd = new Random();

        //create houses
        for (int i = 0; i < rnd.nextInt(maxHouses)+1; i++) {
            Node newHouse = new Node(root);
            houses.add(newHouse);
        }

        //create Rooms
        int roomsNumber = rnd.nextInt(maxRooms)+1;
        int housecounter = 0;
        for (int i = 0; i < roomsNumber-1; i++) {
            Node newRoom = new Node(houses.get(housecounter));
            rooms.add(newRoom);
            if (housecounter == houses.size() - 1) housecounter = 0;
            else housecounter++;
        }

        int roomcounter = 0;

        //create Leaves
        for (int i = 0; i < boxNumber-1; i++) {
            Node newBox = new Node((rnd.nextInt(max+min)-min), rooms.get(roomcounter));
            boxes.add(newBox);
            if (roomcounter == rooms.size() - 1) roomcounter = 0;
            else roomcounter++;
        }


    }


    public int play() {
        return Finder.choseBox(root);
    }

}