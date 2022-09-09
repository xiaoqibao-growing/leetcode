package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 找出所有组合相加之和为某个数的组合
 */
public class CombineSumIII {
    public List<List<Integer>> result = new ArrayList<>();

    public void backtrack(Stack<Integer> stack, int n, int k, int target, int startIndex) {
        if (stack.size() == k) {
            if (stack.stream().mapToInt(x -> x).sum() == target) {
                List<Integer> path = new ArrayList<>(stack);
                result.add(path);
            } else {
                return;
            }
        }

        for (int i = startIndex; i <= n; i++) {
            stack.push(i);
            backtrack(stack, n, k, target, i + 1);
            stack.pop();
        }

        return;
    }

    /**
     * 剪枝优化
     */
    public void backtrackOpt(Stack<Integer> stack, int n, int k, int target, int startIndex) {
        if (stack.size() == k) {
            if (stack.stream().mapToInt(x -> x).sum() == target) {
                List<Integer> path = new ArrayList<>(stack);
                result.add(path);
            } else {
                return;
            }
        }

        for (int i = startIndex; i <= n - (k - stack.size()) + 1; i++) {
            stack.push(i);
            backtrackOpt(stack, n, k, target, startIndex);
            stack.pop();
        }

        return;
    }

    public static void main(String[] args) {
        CombineSumIII combine = new CombineSumIII();
        Stack<Integer> stack = new Stack<>();
        combine.backtrack(stack, 9, 3, 9, 1);
        System.out.println(combine.result);
    }
}
