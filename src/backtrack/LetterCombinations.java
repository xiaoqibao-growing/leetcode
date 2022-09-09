package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 手机号码字母组合
 */
public class LetterCombinations {
    List<List<String>> result = new ArrayList<>();

    public void backtrack(Stack<String> stack, String digit, String[] letters, int index, int num) {
        /**
         * 回溯终止条件是返回下面回溯点的条件
         */
        if (stack.size() == num) {
            List<String> path = new ArrayList<>(stack);
            result.add(path);
            return;
        }

        String letter = letters[digit.charAt(index) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            stack.push(String.valueOf(letter.charAt(i)));
            backtrack(stack, digit, letters, index+1, num);
            stack.pop();
        }

        return;
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        Stack<String> stack = new Stack<>();
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        letterCombinations.backtrack(stack, "23", letters, 0, 2);
        System.out.println(letterCombinations.result);
    }
}
