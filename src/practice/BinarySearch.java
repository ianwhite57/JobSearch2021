package practice;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinarySearch {
    public static void main(String argv[]){
        BinarySearch search = new BinarySearch();
        int[] inputs = new int[]{2, 4, 5, 7, 7, 9, 12, 12, 15};
        List<Integer> inputs2 = Arrays.asList(2, 4, 5, 7, 9, 12, 15);
        int toFind = 7;
        int toFind2 = 13;

        System.out.println(search.findValue(toFind, inputs2));
        System.out.println(search.findValue(toFind2, inputs2));
        System.out.println(search.findFirst(toFind, makeIndexedList(inputs)));
        System.out.println(search.findFirst(toFind2, makeIndexedList(inputs)));
        System.out.println(search.findLast(toFind, makeIndexedList(inputs)));
        System.out.println(search.findLast(toFind2, makeIndexedList(inputs)));
    }

    private boolean findValue(int value, List<Integer> inputs){
        boolean result = false;
        if(inputs.size() > 1) {
            // Find midpoint.  For odd-length inputs it will be center index - 1 due to integer math
            int splitPoint = inputs.size() / 2;
            // Check left side of input list
            result = findValue(value, inputs.subList(0, splitPoint));
            if(!result){
                // If the result didn't show on the left side then check the right side.
                result = findValue(value, inputs.subList(splitPoint, inputs.size()));
            }
        } else {
            if(inputs.get(0) == value){
                result = true;
            }
        }
        return result;
    }

    private int findFirst(int value, List<IndexedNode> inputs){
        int index = -1;
        if(inputs.size() > 1){
            // Find midpoint.  For odd-length inputs it will be center index - 1 due to integer math
            int splitPoint = inputs.size() / 2;

            // Check left side first
            index = findFirst(value, inputs.subList(0, splitPoint));

            if(index == -1){
                index = findFirst(value, inputs.subList(splitPoint, inputs.size()));
            }

        } else {
            if(inputs.get(0).getValue() == value){
                index = inputs.get(0).getIndex();
            }
        }
        return index;
    }

    private int findLast(int value, List<IndexedNode> inputs){
        int index = -1;
        if(inputs.size() > 1){
            // Find midpoint.  For odd-length inputs it will be center index - 1 due to integer math
            int splitPoint = inputs.size() /2;

            // Check right side first
            index = findLast(value, inputs.subList(splitPoint, inputs.size()));

            if(index == -1){
                index = findLast(value, inputs.subList(0, splitPoint));
            }

        } else {
            if(inputs.get(0).getValue() == value){
                index = inputs.get(0).getIndex();
            }
        }
        return index;
    }

    private void printList(List<?> input){
        input.stream().forEach(a -> System.out.print(a + " "));
        System.out.println();
    }

    private static List<IndexedNode> makeIndexedList(int[] input){
        LinkedList<IndexedNode> result = new LinkedList<>();
        for(int i = 0; i < input.length; i++){
            result.add(new IndexedNode(i, input[i]));
        }
        return result;
    }

    /**
     * Class to hold a value and index in a list format instead of an array.
     */
    private static class IndexedNode{
        private int index;
        private int value;
//        private IndexedNode left;
//        private IndexedNode right;

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
}
