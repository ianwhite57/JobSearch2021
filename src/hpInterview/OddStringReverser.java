package hpInterview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OddStringReverser {
    public static void main(String args[])
    {
        System.out.println(reverseOdd("Hello, World."));
        System.out.println(reverseOdd("This is an example sentance."));
    }

    public static String reverseOdd(String input){
        if(input.charAt(input.length() - 1) != '.'){
            return "";
        }

        String[] parts = input.split(" ");
        StringBuilder resultBuilder = new StringBuilder();

        for(int i = 0; i < parts.length; i++){
            if( (i+1)%2 != 0 ){
                parts[i] = reverseString(parts[i]);
            }

            resultBuilder = resultBuilder.append(" ").append(parts[i]);// + " " + parts[i]; // 2 builders
        }

        return resultBuilder.toString().strip();
    }

    private static String reverseString(String input){
        StringBuilder output = new StringBuilder();

        // Check last character for punctuation marks
        // If one is found record it, trim out of input, reverse trimmed input, re-add punctutation at end
        char punctuationMark = 'a';
        if( ",.?!:;'".contains(input.substring(input.length() - 1))){
            punctuationMark = input.charAt(input.length() - 1);
            input = input.substring(0, input.length()-1);
        }

        for(int i = 1; i <= input.length(); i++){
            output = output.append(input.charAt(input.length() - i));
        }

        if(punctuationMark != 'a'){
            output = output.append(punctuationMark);
        }

        return output.toString();
    }
}
