package dp;

import java.util.Arrays;

/**
 * 找到最长对数链
 */
public class  FindLongestChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int length = pairs.length;

        int res = 1;
        int pre = pairs[0][1];
        for (int i = 1; i < length; i++) {
            if (pre < pairs[i][0]) {
                res++;
                pre = pairs[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1, 2};
        int[] b = new int[] {3, 4};
        int[] c = new int[] {1, 3};

        int[][] data = new int[3][];
        data[0] = a;
        data[1] = b;
        data[2] = c;

        FindLongestChain findLongestChain = new FindLongestChain();
        System.out.println(findLongestChain.findLongestChain(data));
    }
}
