package array;

/**
 * 移除元素
 *
 * @author xuejun
 * @date 2022/9/7
 */
public class RemoveElement {
    public int removeElement(int[] nums, int target) {
        int slowIndex = 0;
        int length = nums.length;
        for (int fastIndex = 0; fastIndex < length; fastIndex++) {
            if (nums[fastIndex] != target) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }

        return slowIndex;
    }
}
