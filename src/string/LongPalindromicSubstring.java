package string;

/**
 * 最长回文子串
 */
public class LongPalindromicSubstring {
    /**
     * 使用动态规划解决
     */
    public String getLPSWithDP(String text) {
        if (text == null) {
            return null;
        }

        char[] textChar = text.toCharArray();
        int length = text.length();
        boolean[][] dp = new boolean[length][length];
        int maxLength = 0; // 最长回文子串长度
        int start = 0; // 最长回文子串起始位置

        /**
         * j为子串起始位置，i为子串结束位置
         * 如果dp[j][i]为true，那么dp[j+1][i-1]肯定也得是回文子串
         */
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 2) {
                    dp[j][i] = textChar[i] == textChar[j];
                } else {
                    dp[j][i] = dp[j+1][i-1] && (textChar[i] == textChar[j]);
                }

                if (dp[j][i]) {
                    if (maxLength < i - j + 1) {
                        maxLength = i - j + 1;
                        start = j;
                    }
                }
            }
        }

        return text.substring(start, start + maxLength);
    }

    public boolean isPalindromicString(String text) {
        if (text == null) {
            return false;
        }

        char[] textChar = text.toCharArray();
        int charLength = textChar.length;
        int i = 0, j = charLength - 1;
        while (i < j) {
            if (textChar[i] == textChar[j]) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 暴力解法
     */
    public String getLPSWithViolence(String text) {
        int maxLenght = 0;
        String result = null;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String subString = text.substring(j, i);
                if (isPalindromicString(subString)) {
                    if (subString.length() > maxLenght) {
                        maxLenght = subString.length();
                        result = subString;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "ABCDDCEFA";
        String text2 = "ABCDDCBFA";
        LongPalindromicSubstring lps = new LongPalindromicSubstring();
        System.out.println(lps.getLPSWithDP(text));
        System.out.println(lps.getLPSWithDP(text2));
        System.out.println(lps.getLPSWithViolence(text));
        System.out.println(lps.getLPSWithViolence(text2));
    }
}
