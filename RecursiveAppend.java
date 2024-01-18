/*************************************************************************
 * Compilation: javac RecursiveAppend.java
 * Execution: java RecursiveAppend
 *
 * @author: Prisha Shah
 *
 *************************************************************************/

public class RecursiveAppend {

    // Returns the original string appended to the original string n times
    public static String appendNTimes(String original, int n) {

        // WRITE YOUR CODE HERE
        if (n <= 0)
            return original;
        else
            return original + appendNTimes(original, n - 1);
    }

    public static void main(String[] args) {

        // WRITE TEST CASES HERE to test your method
        System.out.println(appendNTimes("cat", 0));
        System.out.println(appendNTimes("cat", 1));
        System.out.println(appendNTimes("cat", 2));
    }
}
