import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TreeGenerator {

      private final int complexity;
      private final int maxBranches;

    private final Node root;
    private final List<Node> allnodes = new ArrayList<>();


    /**
     * create game Tree
     *
     * @param leavesNumber nunmber of boxes (Leaves)
     * @param minValue       minimal value in a box
     * @param maxValue       maximal value in a box
     */
    public TreeGenerator(int maxBranches, int complexity, int leavesNumber, int maxValue, int minValue) {
        this.root = new Node();
        this.complexity=complexity;
        this.maxBranches=maxBranches;
        setGame(maxBranches, complexity, leavesNumber, maxValue, minValue);
    }

    private void setGame(int maxBranches, int complexity, int leavesNumber, int maxValue, int minValue) {
        Random rnd = new Random();

        List<Node>currentBranchList=new ArrayList<>();
        currentBranchList.add(root);
        allnodes.add(root);
        //createBranch
        for (int i=0; i<complexity; i++){
            List<Node>nextBranchList=new ArrayList<>();
            //create Rooms
            int roomsNumber = rnd.nextInt(maxBranches)+1;
            int upperBranchCounter=0;
            for (int j = 0; j < roomsNumber-1; j++) {
                Node newRoom = new Node(currentBranchList.get(upperBranchCounter));
                nextBranchList.add(newRoom);
                if (upperBranchCounter == currentBranchList.size() - 1)
                    upperBranchCounter = 0;
                else upperBranchCounter++;
                allnodes.add(newRoom);
            }
            currentBranchList=new ArrayList<>(nextBranchList);
            nextBranchList.clear();

        }
        for (Node node: currentBranchList){
            node.setValue(rnd.nextInt(maxValue+minValue)-minValue);
        }


    }

    public void printTree(){
        Node currNode = root;
        System.out.println("Root\n");
        printTree(currNode);
            }

    public void printTree(Node node){
        if (node.isLeaf()){
            System.out.printf("Value: %s\n", node.getValue());
        }
        else {
            System.out.print("°--");
            for (Node child : node.getChildren()) {
                printTree(child);
            }

        }
    }

    public Node getRoot() {
        return root;
    }

//    public void printTree() {
//        List<Node>allNodesCopy= new ArrayList<>(allnodes);
//        StringBuilder tree= new StringBuilder("root");
//        allNodesCopy.removeFirst();
//        Node nextNode= allNodesCopy.getFirst();
//        for (int i=0; i<allNodesCopy.size()-1; i++){
//            allNodesCopy.removeFirst();
//            if (nextNode.isLeaf()){
//                tree.append("-- :").append(nextNode.getValue()).append("\n");
//            }
//            else {
//                tree.append("--").append("\n");
//                nextNode= nextNode.getChildren()
//            }
//        }
//
//
//        }

}
