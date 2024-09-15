package DSA;
import java.util.*;

public class Subsequent {
    public static void main(String[] args) {
        String S = "123";
        int K = 12;
        int result = subsequence(S, K);
        System.out.println("Number of valid subsequences: " + result);
    }

    public static int subsequence(String S, int K) {
        Set<Integer> validSubsequences = new HashSet<>();
        generateSubsequences(S, "", K, validSubsequences);
        return validSubsequences.size();
    }

    private static void generateSubsequences(String str, String current, int k, Set<Integer> validSubsequences) {
        if (str.isEmpty()) {
            if (!current.isEmpty()) {
                try {
                    int num = Integer.parseInt(current);
                    if (num <= k) {
                        validSubsequences.add(num);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }
            return;
        }
        generateSubsequences(str.substring(1), current + str.charAt(0), k, validSubsequences);
        generateSubsequences(str.substring(1), current, k, validSubsequences);
    }
}
