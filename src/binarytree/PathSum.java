package binarytree;

/**
 * 路径之和
 */
public class PathSum {
    /**
     *  递归解法
     */
    public boolean pathSumRecurition(TreeNode root, int sum, int target) {
        sum += root.val;
        if (root.left == null && root.right == null) {
            if (sum == target) {
                return true;
            }
        }

        if (root.left != null) {
            if (pathSumRecurition(root.left, sum, target)) {
                return true;
            }
        }

        if (root.right != null) {
            if (pathSumRecurition(root.right, sum, target)) {
                return true;
            }
        }

        return false;
    }

    /**
     *  递归解法
     *  明显回溯
     */
    public boolean pathSumRecuritionBacktracking(TreeNode root, int sum, int target) {
        if (root.left == null && root.right == null) {
            if (sum == target) {
                return true;
            }
        }

        if (root.left != null) {
            sum += root.left.val;
            if (pathSumRecuritionBacktracking(root.left, sum, target)) {
                return true;
            }
            sum -= root.left.val; // 回溯
        }

        if (root.right != null) {
            sum += root.right.val;
            if (pathSumRecuritionBacktracking(root.right, sum, target)) {
                return true;
            }
            sum -= root.right.val;
        }

        return false;
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

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.pathSumRecurition(root, 0, 7));

        System.out.println(pathSum.pathSumRecuritionBacktracking(root, root.val, 7));
    }
}
