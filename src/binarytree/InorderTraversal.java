package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree的中序遍历，包括递归遍历和迭代遍历
 *
 * @author xuejun
 * @date 2022/8/8 晚上
 */
public class InorderTraversal {
    // 以下为递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        inorderTraversal(root, result);
        return result;
    }

    public void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }

    // 以下为迭代写法
    /**
     * 思路： BFS搜索
     * @param root
     * @return
     */
    public List<Integer> inorderIterableTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        // 深度优先搜索
        while (!stack.empty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;
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

        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.inorderIterableTraversal(root));
        System.out.println(inorderTraversal.inorderTraversal(root));
    }
}
