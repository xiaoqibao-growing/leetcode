package dp;

public class Fibonacci {
    public int fibRecursion(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return fibRecursion(n - 1) + fibRecursion(n - 2);

    }

    public int fibDp(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int fibCur(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int pre = 1;
        int cur = 1;

        for (int i = 3; i < n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }

        return cur;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibRecursion(5));
    }
}
