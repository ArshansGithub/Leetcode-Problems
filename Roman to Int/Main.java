import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static HashMap<String, Integer> symbolToValue;
    public static String[] romanChar = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static void main(String[] args) {
        //String baseInput = "IIIIM";

        symbolToValue = new HashMap<String, Integer>();
        symbolToValue.put("I", 1);
        symbolToValue.put("V", 5);
        symbolToValue.put("X", 10);
        symbolToValue.put("L", 50);
        symbolToValue.put("C", 100);
        symbolToValue.put("D", 500);
        symbolToValue.put("M", 1000);

        symbolToValue.put("IV", 4);
        symbolToValue.put("IX", 9);
        symbolToValue.put("XL", 40);
        symbolToValue.put("XC", 90);
        symbolToValue.put("CD", 400);
        symbolToValue.put("CM", 900);

        //System.out.println(RomantoInt(baseInput));
        //System.out.println(IntToRoman(1994));

        int success = 0;
        int fail = 0;
        
        for (int counter = 0; counter <= 4000; counter++) {
            String romanNumeral = IntToRoman(counter);

            int persianAnswer = RomantoInt(romanNumeral);
            int testAnswer = placeholder(romanNumeral);

            if (persianAnswer != testAnswer) {
                fail++;
                System.out.println("Failed on testcase '" + romanNumeral + "' : Expected: '" + persianAnswer + "' | Got: '" + testAnswer + "'");
            } else {
                success++;
            }
        }

        System.out.println("Finished checking test cases! Success: " + success + " | Failed: " + fail);
    }

    public static int placeholder(String a) {
        return 0;
    }

    public static String IntToRoman(int numba) {
        String toReturn = "";

        for (String symbol : romanChar) {
            int currentVal = symbolToValue.get(symbol);
            
            if (numba >= currentVal) {
    
                int maxInsertion = numba / currentVal;

                numba -= maxInsertion * currentVal;

                toReturn += String.valueOf(symbol).repeat(maxInsertion);

            }
        }
        
        return toReturn;
    }

    public static int RomantoInt(String input) {
        char[] inputCharArray = input.toCharArray();
        int toReturn = 0;

        for (int charCount = 0; charCount < inputCharArray.length; charCount++) {
            int currentSymbolValue = symbolToValue.get(String.valueOf(inputCharArray[charCount]));

            if (
                charCount + 1 == inputCharArray.length || 
                currentSymbolValue >= symbolToValue.get(String.valueOf(inputCharArray[charCount + 1])) 
                ) {

                toReturn += currentSymbolValue;

            } else {
                toReturn += symbolToValue.get(String.valueOf(inputCharArray[charCount + 1])) - currentSymbolValue;
                charCount++;
            }
            
        }

        return toReturn;
    }
}
