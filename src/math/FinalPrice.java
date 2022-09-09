package math;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 */
public class FinalPrice {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int select = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    select = prices[j];
                    break;
                }
            }

            result[i] = prices[i] - select;
        }

        result[prices.length - 1] = prices[prices.length - 1];

        return result;
    }

    public int[] finalPrices1(int[] prices) {
        int [] res = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>(); // 单调栈

        for (int i = prices.length-1; i >= 0 ; i--) { // 倒序维护单调栈
            while(!stack.isEmpty() && prices[i]<stack.peekLast()){ // 维护一个单调递增栈(总保持栈顶元素最大)：取到元素右边第一个小于等于其的值
                stack.pollLast(); // 如果当前元素小于栈顶元素 栈顶的弹走
            }
            // 执行至此，要么栈空，要么当前元素大于等于栈顶元素
            res[i] = stack.isEmpty()?-1:stack.peekLast(); // 栈空取-1，否则取栈顶，栈顶取到的即为右边第一个小于等于其的值。
            stack.add(prices[i]); // 将当前元素push进来作为栈顶（保持栈顶元素最大）
        }
        for (int i = 0; i < prices.length; i++) {
            if (res[i] == -1) { // 右边没有比其小的值
                res[i] = prices[i];
            }else {
                res[i] = prices[i] - res[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FinalPrice finalPrice = new FinalPrice();
        int[] testData1 = new int[] {8, 4, 6, 2, 3};
        System.out.println(Arrays.toString(finalPrice.finalPrices(testData1)));

        int[] testData2 = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(finalPrice.finalPrices(testData2)));

        int[] testData3 = new int[] {10, 1, 1, 6};
        System.out.println(Arrays.toString(finalPrice.finalPrices(testData3)));
    }
}
