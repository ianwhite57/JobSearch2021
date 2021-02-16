package practice.BinarySearch;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String argv[]){
        BinarySearch search = new BinarySearch();
        List<Integer> inputs = Arrays.asList(2, 4, 5, 7, 7, 9, 12, 12, 15);
        List<Integer> inputs2 = Arrays.asList(2, 4, 5, 7, 9, 12, 15);
        int toFind = 7;
        int toFind2 = 13;

        System.out.println(search.findValue(toFind, inputs2));
        System.out.println(search.findValue(toFind2, inputs2));
        System.out.println(search.findFirst(toFind, search.makeIndexedList(inputs)));
        System.out.println(search.findFirst(toFind2, search.makeIndexedList(inputs)));
        System.out.println(search.findLast(toFind, search.makeIndexedList(inputs)));
        System.out.println(search.findLast(toFind2, search.makeIndexedList(inputs)));
    }
}
