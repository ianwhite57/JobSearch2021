package practice.BinarySearch;

public class IndexedNode {
    private int index;
    private int value;

    public IndexedNode (int idx, int val){
        this.index = idx;
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public int getIndex(){
        return index;
    }

    public String toString(){
        return "(index " + index + ", value " + value + ")";
    }
}
