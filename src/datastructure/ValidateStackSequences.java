package datastructure;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        ValidateStackSequences stackSequences = new ValidateStackSequences();
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        System.out.println(stackSequences.validateStackSequences(pushed, popped));

        int[] pushed1 = new int[]{1,2,3,4,5};
        int[] popped2 = new int[]{4,3,5,1,2};
        System.out.println(stackSequences.validateStackSequences(pushed1, popped2));
    }
}
