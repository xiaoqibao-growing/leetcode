package binarytree;

import java.util.Stack;

/**
 * 翻转一个二叉树
 */
public class InvertTree {
    public void invertTree(TreeNode root) {
        invertTreeRecursion(root);
    }

    public void invertTreeRecursion(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode cur = root;
        TreeNode left = cur.left;
        cur.left = cur.right;
        cur.right = left;

        invertTree(root.left);
        invertTree(root.right);
    }

    public void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public void invertTreeIterable(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            swap(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
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

        InvertTree invertTree = new InvertTree();
        // invertTree.invertTree(root);
        invertTree.invertTreeIterable(root);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
    }
}
