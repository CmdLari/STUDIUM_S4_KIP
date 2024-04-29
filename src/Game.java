import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.StringTemplate.STR;

public class Game {
    private TreeGenerator treeGenerator;



    public Game(int maxBranches, int complexity, int leavesNumber, int maxValue, int minValue) {
       treeGenerator= new TreeGenerator(maxBranches,complexity,leavesNumber,maxValue,minValue);

    }

//    private void setGame(int boxNumber, int max, int min) {
//        Random rnd = new Random();
//
//        //create houses
//        for (int i = 0; i < rnd.nextInt(maxHouses)+1; i++) {
//            Node newHouse = new Node(root);
//            houses.add(newHouse);
//        }
//
//        //create Rooms
//        int roomsNumber = rnd.nextInt(maxRooms)+1;
//        int housecounter = 0;
//        for (int i = 0; i < roomsNumber-1; i++) {
//            Node newRoom = new Node(houses.get(housecounter));
//            rooms.add(newRoom);
//            if (housecounter == houses.size() - 1) housecounter = 0;
//            else housecounter++;
//        }
//
//        int roomcounter = 0;
//
//        //create Leaves
//        for (int i = 0; i < boxNumber-1; i++) {
//            Node newBox = new Node((rnd.nextInt(max+min)-min), rooms.get(roomcounter));
//            boxes.add(newBox);
//            if (roomcounter == rooms.size() - 1) roomcounter = 0;
//            else roomcounter++;
//        }
//
//
//    }


    public int play() {
        treeGenerator.printTree();
        return Finder.choseBox(treeGenerator.getRoot());
    }

//    public void printTree() {
//        System.out.println("root");
//        int houseCounter=1;
//        for (Node house : houses) {
//            System.out.println("----house" + houseCounter+ " :");
//            houseCounter++;
//            int roomCounter=1;
//            for (Node room : house.getChildren()) {
//                System.out.println("-----------room" + roomCounter+ " :");
//                for (Node box : room.getChildren()) {
//                    System.out.println(STR."----------------[\{box.getValue()}]");
//                }
//                roomCounter++;
//            }
//        }
//    }


}