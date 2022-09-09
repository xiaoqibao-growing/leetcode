package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集2
 */
public class SubsetsII {
    List<List<Integer>> result = new ArrayList<>();
    public void backtrack(LinkedList<Integer> path, int[] data, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= data.length) {
            return;
        }

        for (int i = startIndex; i < data.length; i++) {
            if (i > startIndex && data[i] == data[i - 1]) {
                continue;
            }
            path.add(data[i]);
            backtrack(path, data, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        int[] data = new int[] {1, 2, 2};
        
        Arrays.sort(data);
        LinkedList<Integer> path = new LinkedList<>();
        subsetsII.backtrack(path, data, 0);
        System.out.println(subsetsII.result);
    }
}
