package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 排列问题，找到数组的全排列
 *
 * @author xuejun
 * @date 2022/9/7
 */
public class Permute {
    public List<List<Integer>> result = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[3];
        backtrack(nums, used);
        return result;
    }

    public void backtrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 2};
        Permute permute = new Permute();
        boolean[] used = new boolean[nums.length];
        permute.backtrack(nums, used);
        System.out.println(permute.result);
    }
}
