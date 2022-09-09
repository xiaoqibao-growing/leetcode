package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 组合问题
 */
public class Combine {
    private List<List<Integer>> result = new ArrayList<>();

    public void backtrack(Stack<Integer> stack, int k, int n, int startIndex) {
        System.out.println(startIndex);
        System.out.println(stack.toString());
        // 终止，收集结果
        if (stack.size() == k) {
            List<Integer> path = new ArrayList<>(stack);
            result.add(path);
            return;
        }

        for (int i = startIndex; i <= n - (k - stack.size()) + 1; i++) {
            stack.push(i);
            backtrack(stack, k, n, i + 1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        Stack<Integer> stack = new Stack<>();
        combine.backtrack(stack, 2, 4, 1);
        System.out.println(combine.result);
    }
}
