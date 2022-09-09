package array;

import java.util.Arrays;

/**
 * 排序的平方值
 *
 * @author xuejun
 * @date 2022/9/8
 */
public class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        while (left <= right) {
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];
            if (a <= b) {
                right--;
                result[index--] = b;
            } else {
                left++;
                result[index--] = a;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-6, -5, 0, 1, 2, 5, 6};
        SortedSquares sortedSquares = new SortedSquares();
        System.out.println(Arrays.toString(sortedSquares.sortedSquares(nums)));
    }
}
