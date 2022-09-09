package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 寻找递增序列
 */
public class IncreasingSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    public void backtrack(Stack<Integer> path, int[] data, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
            // 此处不能返回，因为要收集长度为2 3 4 5 。。的数据
        }

        // 会有重复数据，因此需要去重
        int[] used = new int[201];
        for (int i = startIndex; i < data.length; i++) {
            int temp = -101;
            if (path.size() != 0) {
                temp = path.peek();
            }

            if (data[i] >= temp && used[data[i] + 100] != 1) {
                used[data[i] + 100] = 1;
                path.push(data[i]);
            } else {
                continue;
            }
            backtrack(path, data, i + 1);
            path.pop();
        }

        return;
    }

    public static void main(String[] args) {
        int[] data = new int[] {4, 6, 7, 7};
        Stack<Integer> stack = new Stack<>();
        IncreasingSubsequences increasingSubsequences = new IncreasingSubsequences();
        increasingSubsequences.backtrack(stack, data, 0);
        System.out.println(increasingSubsequences.result);
    }
}
