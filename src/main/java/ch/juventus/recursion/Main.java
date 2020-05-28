package ch.juventus.recursion;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Recursion start: " + System.currentTimeMillis());
        int fib1 = recursion(40);
        System.out.println("Recursion end ("+fib1+"): " + System.currentTimeMillis());

        System.out.println("Iteration start: " + System.currentTimeMillis());
        int fib2 = iteration(40);
        System.out.println("Iteration end ("+fib2+"): " + System.currentTimeMillis());

        List<String> testInput = getPalindromeTestInput();
        testInput.stream()
                .forEach(input -> System.out.println("Palindrome: " + isPalindrome(input)));
    }

    private static int recursion(int n) {
        if (n < 2) {
            return n;
        } else {
            return recursion(n-2) + recursion(n-1);
        }
    }

    private static int iteration(int n) {
        int fib = 0;
        int prev = 1;
        for (int i = 0; i < n; i++) {
            int temp = fib;
            fib += prev;
            prev = temp;
        }
        return fib;
    }

    private static boolean isPalindrome(String input) {
        if(input.length() < 2) {
            return true;
        }
        input = input.toLowerCase();
        if(input.substring(0, 1).equals(input.substring(input.length()-1))) {
            return isPalindrome(input.substring(1, input.length()-1));
        } else {
            return false;
        }
    }

    private static List<String> getPalindromeTestInput() {
        List<String> testInput = new ArrayList<>();
        testInput.add("Anna");
        testInput.add("Korb");
        testInput.add("Bob");
        testInput.add("Mein Computer");
        testInput.add("Level");
        testInput.add("Fuss");
        testInput.add("Anna Bob Anna");
        testInput.add("Kamel und Stein");
        testInput.add("!+Level+!");
        return testInput;
    }
}
