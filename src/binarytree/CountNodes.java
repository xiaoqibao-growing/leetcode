package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                count++;
                queue.add(cur.left);
            }
            if (cur.right != null) {
                count++;
                queue.add(cur.right);
            }
        }

        return count;
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

        CountNodes countNodes = new CountNodes();
        System.out.println(countNodes.countNodes(root));
    }
}
