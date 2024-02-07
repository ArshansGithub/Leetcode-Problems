// Arshan's Palindrome Solution | Jan 31 2024
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> testCases = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {
        int success = 0;
        int fail = 0;

        String testFilename = "testcases.txt";

        getTestCases(testFilename);

        for (String eachTestCase : testCases) {
            boolean check = input(eachTestCase);

            if (check == true) {
                success++;
            } else {
                fail++;
                System.out.println("Failed palindrome check: " + eachTestCase);
            }
        }

        System.out.println("Tests Completed\nPassed: " + success + " | Failed: " + fail);

    }

    public static void getTestCases(String filename) throws FileNotFoundException {
        File testCasesFile = new File(filename);

        Scanner fileReader = new Scanner(testCasesFile);

        while (fileReader.hasNextLine()) {
            String testCase = fileReader.nextLine();

            testCases.add(testCase);
        }

        fileReader.close();
    }

    public static boolean input(String word) {
        String reverse = palli(word);
        if (word.equals(reverse)) {
          return true;
        } else {
          return false;
        }
    }
    
    public static String palli(String word) {
        String reverse = "";
        char ch;
    
        for (int i = word.length() - 1; i >= 0; i--) {
          ch = word.charAt(i);
          reverse = reverse + ch;
        }
        return reverse;
    
      }
    

    
}