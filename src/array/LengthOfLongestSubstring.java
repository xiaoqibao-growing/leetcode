package array;

import java.util.HashMap;

/**
 * 最长不重复子串
 *
 * @author xuejun
 * @date 2022/9/9
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> dict = new HashMap<>(s.length());
        int i = 0;
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dict.containsKey(s.substring(j, j+1))) {
                i = Math.max(i, dict.get(s.substring(j, j + 1)) + 1);
                System.out.println(i + "   " + j);
            }
            dict.put(s.substring(j,j+1), j);
            result = Math.max(result, j - i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }
}
