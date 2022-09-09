package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 分割回文子串
 */
public class PartitionPalindromic {
    public List<List<String>> result = new ArrayList<>();

    public void backtrack(Stack<String> path, String source, int startIndex) {
        if (startIndex >= source.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < source.length(); i++) {
            if (isPalindromic(source.substring(startIndex, i + 1))) {
                path.push(source.substring(startIndex, i + 1));
            } else {
                continue;
            }

            backtrack(path, source, i + 1);
            path.pop();
        }
    }

    public boolean isPalindromic(String source) {
        int start = 0;
        int end = source.length() - 1;
        while (start <= end) {
            if (source.charAt(start) == source.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PartitionPalindromic partitionPalindromic = new PartitionPalindromic();
        Stack<String> path = new Stack<>();
        String source = "aab";
        partitionPalindromic.backtrack(path, source, 0);
        System.out.println(partitionPalindromic.result);
    }
}
