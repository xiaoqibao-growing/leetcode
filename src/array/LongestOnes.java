package array;

/**
 * 翻转k次0，找出最长的连续为1的长度
 * 1,1,1,0,0,0,1,1,1,1,0
 *
 * @author xuejun
 * @date 2022/9/9
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int count = 0;
        int result = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                count++;
            }

            while (count > k) {
                if (nums[i] == 0) {
                    count--;
                }
                i++;
            }

            result = Math.max(result, (j - i + 1));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        LongestOnes longestOnes = new LongestOnes();
        System.out.println(longestOnes.longestOnes(nums, k));
    }
}
