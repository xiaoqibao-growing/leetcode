package binarytree;

/**
 * 左叶子结点之和
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumOfLeftLeaves(root.left);
        int rightSum = sumOfLeftLeaves(root.right);

        int mid = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            mid = root.left.val;
        }

        return leftSum + rightSum + mid;
    }
}
