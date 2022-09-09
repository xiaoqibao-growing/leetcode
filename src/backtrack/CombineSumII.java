package backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 组合II，找出数组中和为某个值的组合，每个数只能使用一次
 */
public class CombineSumII {
    public List<List<Integer>> result = new ArrayList<>();
    public void backtrack(List<Integer> data, Stack<Integer> path, boolean[] flag, int target, int startIndex) {
        if (path.stream().mapToInt(m -> m).sum() == target) {
            result.add(new ArrayList<>(path));
            return;
        } else if (path.stream().mapToInt(m -> m).sum() > target) {
            return;
        }

        for (int i = startIndex; i < data.size(); i++) {
            if (i != 0 && data.get(i) == data.get(i - 1) && !flag[i - 1]) {
                continue;
            }

            flag[i] = true;
            path.push(data.get(i));
            backtrack(data, path, flag, target, i + 1);
            flag[i] = false;
            path.pop();
        }

        return;
    }

    public static void main(String[] args) {
        List<Integer> data = new ArrayList<>();
        data.add(10);
        data.add(1);
        data.add(2);
        data.add(7);
        data.add(6);
        data.add(1);
        data.add(5);

        Collections.sort(data);
        CombineSumII combineSumII = new CombineSumII();
        Stack<Integer> path = new Stack<>();
        boolean[] flag = new boolean[data.size()];
        combineSumII.backtrack(data, path, flag, 8, 0);
        System.out.println(combineSumII.result);
    }
}
