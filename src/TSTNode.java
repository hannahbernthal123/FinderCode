public class TSTNode {
    String value;
    TSTNode[] nextNodes;
    int num;

    public TSTNode(int num) {
        this.num = num;
        String value = "";
        nextNodes = new TSTNode[3];
    }


    public String getValue() {
        return value;
    }

    public void setLeft(TSTNode node) {
        nextNodes[0] = node;
    }

    public void setCenter(TSTNode node) {
        nextNodes[1] = node;
    }
    public void setRight(TSTNode node) {
        nextNodes[2] = node;
    }

    public void setVal(String word) {
        value = word;
    }

    public TSTNode getLeft() {
        return nextNodes[0];
    }

    public TSTNode getRight() {
        return nextNodes[2];
    }

    public TSTNode getCenter() {
        return nextNodes[1];
    }

    public int getNum() {
        return num;
    }

    // Function that drops you down to the next node options.
    public TSTNode[] getNext() {
        return nextNodes;
    }
}