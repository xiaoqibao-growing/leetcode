package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 求出字符串中唯一字符的个数
 */
public class UniqueLetterString {
    List<String> result = new ArrayList<>();
    
    public int uniqueLetterString(String s) {
        return 0;
    }
    
    public void backtrack(LinkedList<String> path, String s, int startIndex) {
        result.add(String.join("", path));
        if (startIndex >= s.length()) {
            return;
        }

        char[] strChar = s.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            path.add(s.substring(startIndex, i));
            backtrack(path, s, i + 1);
            path.removeLast();
        }

        return;
    }

    public static void main(String[] args) {
        String s = "ABC";
        LinkedList<String> path = new LinkedList<>();
        UniqueLetterString uniqueLetterString = new UniqueLetterString();
        uniqueLetterString.backtrack(path, s, 0);
        System.out.println(uniqueLetterString.result);
    }
}
