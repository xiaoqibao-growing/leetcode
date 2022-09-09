package binarytree;

public class MinDepth {
    public int minDepthRecursion(TreeNode root) {
        int leftDepth = minDepthRecursion(root.left);
        int rightDepth = minDepthRecursion(root.right);
        
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }

        return 1 + Math.min(leftDepth, rightDepth);
    }
    
}
