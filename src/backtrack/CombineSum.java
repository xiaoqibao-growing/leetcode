package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数组组合，给定一个无重复元素数组，找出数组中和为target的组合
 */
public class CombineSum {
    public List<List<Integer>> result = new ArrayList<>();

    public void backtrack(Stack<Integer> stack, List<Integer> condidates, int index, int target) {
        if (stack.stream().mapToInt(x -> x).sum() == target) {
            List<Integer> path = new ArrayList<>(stack);
            result.add(path);

            if (index == condidates.size()) {
                return;
            }
        } else if (stack.stream().mapToInt(x -> x).sum() > target) {
            return;
        }

        for (int i = index; i < condidates.size(); i++) {
            stack.push(condidates.get(i));
            backtrack(stack, condidates, i, target);
            stack.pop();
        }

        return;
    }

    public void backtrack(int sum, List<Integer> path, List<Integer> condidates, int index, int target) {
        if (sum == target) {
            result.add(path);
        } else if (sum > target) {
            return;
        }

        for (int i = index; i < condidates.size(); i++) {
            sum += condidates.get(i);
            path.add(condidates.get(i));
            backtrack(sum, path, condidates, i, target);
            sum -= condidates.get(i);
            path.remove(condidates.get(i));
        }

        return;
    }

    public static void main(String[] args) {
        CombineSum combineSum = new CombineSum();
        Stack<Integer> stack = new Stack<>();
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);
        combineSum.backtrack(stack, data, 0, 7);
        System.out.println(combineSum.result);
    }
}
