package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 求子集
 */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();

    public void backtrack1(Stack<Integer> sets, List<Integer> data, int startIndex) {
        System.out.println("sets: ----- " + sets + "  index: " + startIndex);
        if (startIndex >= data.size()) {
            result.add(new ArrayList<>(sets));
            System.out.println("result: " + result);
            return;
        }

        for (int i = startIndex; i < data.size(); i++) {
            System.out.println("sets: " + sets + " i: " + i);
            sets.push(data.get(i));
            backtrack1(sets, data, i + 1);
            sets.pop();
        }
    }

    public void backtrack(Stack<Integer> sets, List<Integer> data, int startIndex) {
        result.add(new ArrayList<>(sets));
        if (startIndex >= data.size()) {
            return;
        }

        for (int i = startIndex; i < data.size(); i++) {
            sets.push(data.get(i));
            backtrack(sets, data, i + 1);
            sets.pop();
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        Stack<Integer> sets = new Stack<>();
        List<Integer> data = new ArrayList<>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(5);

        subsets.backtrack1(sets, data, 0);
        System.out.println(subsets.result);
    }
}
