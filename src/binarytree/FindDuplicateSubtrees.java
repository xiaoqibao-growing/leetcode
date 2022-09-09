package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {



    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> dict = new HashMap<>();
        bfs(result, root, dict);

        return result;
    }

    public String bfs(List<TreeNode> result, TreeNode root, Map<String, Integer> dict) {
        if (root == null) {
            return "";
        }

        String key = root.val + "_" + bfs(result, root.left, dict) + "_" + bfs(result, root.right, dict);
        dict.put(key, dict.getOrDefault(key, 0) + 1);

        if (dict.get(key) == 2) {
            result.add(root);
        }

        return key;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(4);

        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        System.out.println(findDuplicateSubtrees.findDuplicateSubtrees(root));
    }
}
