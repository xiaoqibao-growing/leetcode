package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 复原IP地址
 */
public class RestoreIpAddress {

    List<String> result = new ArrayList<>();

    public void backtrack(Stack<String> path, String source, int startIndex) {
        if (path.size() == 4) {
            String temp = String.join("", path);
            if (temp.length() != source.length()) {
                return;
            }
            result.add(String.join(".", path));
            return;
        }

        for (int i = startIndex; i < source.length(); i++) {
            String subString = source.substring(startIndex, i + 1);

            if (isValidIp(subString)) {
                path.add(subString);
            } else {
                continue;
            }

            backtrack(path, source, i + 1);
            path.pop();
        }

        return;
    }
    
    public boolean isValidIp(String ip) {
        if (ip == null || ip.trim().length() == 0) {
            return false;
        }
        if (ip.length() > 3) {
            return false;
        }

        if (ip.length() > 1 && ip.startsWith("0")) {
            return false;
        }

        if (Integer.parseInt(ip) > 255) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        RestoreIpAddress iAddress = new RestoreIpAddress();
        String s = "25525511135";
        Stack<String> path = new Stack<>();
        iAddress.backtrack(path, s, 0);
        System.out.println(iAddress.result);

        String s1 = "0000";
        iAddress.backtrack(path, s1, 0);
        path.clear();
        System.out.println(iAddress.result);
    }
}
