package math;

/**
 * 二进制中1的个数
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight(3));
    }
}
