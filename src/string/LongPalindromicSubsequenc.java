package string;

/**
 * 最长回文子序列，注意和回文的区别
 */
public class LongPalindromicSubsequenc {
    /**
     * 获取长度
     * lps[i][j]表示从i到j的最长子序列
     */
    public int getLPS(String text) {
        char[] textChar = text.toCharArray();
        int length = textChar.length;
        int[][] lps = new int[length][length];
        for (int i = 0; i < length; i++) {
            lps[i][i] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 0; i + j < length; j++) {
                if (textChar[j] == textChar[i + j]) {
                    lps[j][i+j] = lps[j+1][i+j-1] + 2;
                } else {
                    lps[j][i+j] = Math.max(lps[j][i+j-1], lps[j+1][i+j]);
                }
            }
        }

        return lps[0][length-1];
    }

    public static void main(String[] args) {
        LongPalindromicSubsequenc lps = new LongPalindromicSubsequenc();
        System.out.println(lps.getLPS("abcabcd"));
    }
}
