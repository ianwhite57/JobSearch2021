package hpInterview;//'main' method must be in a class 'Rextester'.

import java.lang.*;

class Rextester
{
    public static void main(String args[])
    {
        System.out.println("Hello, World!");
        System.out.println(parameterizedPrinter("a3b2c1d0e1"));
        System.out.println(parameterizedPrinter("abc2c1d0"));
        System.out.println(parameterizedPrinter("ab!c2"));
    }

    //Input:  ak3b2c1d0
    //output: akakakbbc

    private static String parameterizedPrinter(String input){
        String workingStr = input;
        String result = "";

        while(workingStr.length() > 1){
            String toRepeat = findStr(workingStr);
            int count = Character.getNumericValue(workingStr.charAt(toRepeat.length())); //Integer.parseInt(workingStr.substring(toRepeat.length(), toRepeat.length() + 1));
            String chars = "";
            for(int j = 0; j < count; j++){
                chars = chars + toRepeat;
            }

            result += chars;
            workingStr = workingStr.substring(toRepeat.length() + 1);
        }

        return result;
    }

    private static String findStr(String input){
        String str = "";
        for(int i = 0; i < input.length(); i++){
            if(Character.isLetter(input.charAt(i))){
                str += input.charAt(i);
            } else if (Character.isDigit(input.charAt(i))) {
                break;
            } else {
                throw new RuntimeException("Non-alphanumeric character \'" + input.charAt(i) + "\' found");
            }
        }
        return str;
    }
}