package practice.BinarySearch;

import java.util.LinkedList;
import java.util.List;

public class BinarySearch {
    public boolean findValue(int value, List<Integer> inputs){
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

    public int findFirst(int value, List<IndexedNode> inputs){
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

    public int findLast(int value, List<IndexedNode> inputs){
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

    public List<IndexedNode> makeIndexedList(List<Integer> input){
        LinkedList<IndexedNode> result = new LinkedList<>();
        for(int i = 0; i < input.size(); i++){
            result.add(new IndexedNode(i, input.get(i)));
        }
        return result;
    }
}
