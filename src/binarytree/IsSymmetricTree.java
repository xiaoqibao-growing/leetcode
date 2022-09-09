package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断树是否对称
 */
public class IsSymmetricTree {
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        boolean outside = isSymmetric(left.left, right.right);
        boolean inside = isSymmetric(left.right, right.left);

        return outside && inside;
    }

    public boolean isSymmetricByQueue(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || (left.val != right.val)) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(5);

        IsSymmetricTree isSymmetricTree = new IsSymmetricTree();
        System.out.println(isSymmetricTree.isSymmetricByQueue(root));
    }
}
