public class Finder {


    public static int choseBox(Node root){
        return choseMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private static int choseMin(Node node, int alpha, int beta) {
        if (node.isLeaf()) return node.getValue();
        for (Node child : node.getChildren()) {
            beta = Math.min(beta, choseMax(child, alpha, beta));
            if (alpha >= beta) return beta;
        }
        return beta;
    }

    private static int choseMax(Node node, int alpha, int beta){
        //vorzeitiger Abbruch da Node=Leaf
        if (node.isLeaf()) return node.getValue();
        for(Node child : node.getChildren()){
            alpha = Math.max(alpha, choseMin(child,alpha,beta));
            if (alpha >= beta) return alpha;
        }
        return alpha;
    }

}