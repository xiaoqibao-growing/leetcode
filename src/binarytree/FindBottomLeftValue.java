package binarytree;

/**
 * 寻找最左边叶子结点的值
 */
public class FindBottomLeftValue {
    int leftValue;
    int maxDepth = Integer.MIN_VALUE;
    public void traversal(TreeNode root, int leftDepth) {
        if (root.left == null && root.right == null) {
            // 最深的树找到的第一个肯定是最左的叶子结点
            if (leftDepth > maxDepth) {
                maxDepth = leftDepth;
                leftValue = root.val;
            }
        }

        if (root.left != null) {
            leftDepth++;
            traversal(root.left, leftDepth);
            leftDepth--;
        }

        if (root.right != null) {
            leftDepth++;
            traversal(root.right, leftDepth);
            leftDepth--;
        }
    }

    public void traversal1(TreeNode root, int leftDepth) {
        if (root.left == null && root.right == null) {
            // 最深的树找到的第一个肯定是最左的叶子结点
            if (leftDepth > maxDepth) {
                maxDepth = leftDepth;
                leftValue = root.val;
            }
        }

        if (root.left != null) {
            traversal1(root.left, leftDepth + 1);
        }

        if (root.right != null) {
            traversal1(root.right, leftDepth + 1);
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

        FindBottomLeftValue findBottomLeftValue = new FindBottomLeftValue();
        findBottomLeftValue.traversal1(root, 0);
        System.out.println(findBottomLeftValue.leftValue);
    }
}
