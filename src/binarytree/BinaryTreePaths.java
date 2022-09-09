package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的全部路径
 */
public class BinaryTreePaths {
    public void traversal(TreeNode root, Stack<Integer> stack, List<String> result) {
        stack.push(root.val);
        // 回溯终止条件，写路径到result
        if (root.left == null && root.right == null) {
            int size = stack.size();
            String path = "";
            for (int i = 0; i< size - 1; i++) {
                path += stack.get(i).toString() + "->";
            }
            path += stack.get(size-1).toString();
            result.add(path);
        }

        if (root.left != null) {
            traversal(root.left, stack, result);
            stack.pop();
        }

        if (root.right != null) {
            traversal(root.right, stack, result);
            stack.pop();
        }
    }

    public void binaryTreePaths(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        List<String> path = new ArrayList<>();
        if (root == null) {
            return;
        }
        traversal(root, stack, path);
        System.out.println(path);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        binaryTreePaths.binaryTreePaths(root);
    }
}
