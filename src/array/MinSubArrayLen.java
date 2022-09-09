package array;

/**
 * 最小连续数组长度
 *
 * @author xuejun
 * @date 2022/9/8
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int minSubLen = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum >= target) {
                int tempLen = j - i + 1;
                minSubLen = Math.min(minSubLen, tempLen);
                sum -= nums[i++];
            }
        }

        return minSubLen == Integer.MAX_VALUE ? 0 : minSubLen;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,1,1,1,1,1};
        int target = 11;
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
    }
}
