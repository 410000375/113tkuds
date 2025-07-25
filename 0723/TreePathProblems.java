import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 功能 1：找出所有從根到葉節點的路徑
    public static List<List<Integer>> allRootToLeafPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsPaths(root, path, result);
        return result;
    }

    private static void dfsPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;
        path.add(node.val);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            dfsPaths(node.left, path, result);
            dfsPaths(node.right, path, result);
        }

        path.remove(path.size() - 1);
    }

    // 功能 2：是否有和為 target 的根到葉路徑
    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == target;
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }

    // 功能 3：找出和最大的根到葉節點路徑
    public static List<Integer> maxPathSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        maxPathDfs(root, current, result, 0, new int[]{Integer.MIN_VALUE});
        return result;
    }

    private static void maxPathDfs(TreeNode node, List<Integer> current, List<Integer> result, int sum, int[] maxSum) {
        if (node == null) return;

        current.add(node.val);
        sum += node.val;

        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                result.clear();
                result.addAll(current);
            }
        } else {
            maxPathDfs(node.left, current, result, sum, maxSum);
            maxPathDfs(node.right, current, result, sum, maxSum);
        }

        current.remove(current.size() - 1);
    }

    // 測試
    public static void main(String[] args) {
        /*
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("功能 1：所有根到葉節點的路徑");
        List<List<Integer>> paths = allRootToLeafPaths(root);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

        System.out.println("\n功能 2：是否有和為 22 的根到葉節點路徑？");
        System.out.println(hasPathSum(root, 22)); // true

        System.out.println("\n功能 3：和最大的根到葉節點路徑");
        List<Integer> maxPath = maxPathSum(root);
        System.out.println("最大和路徑：" + maxPath);
    }
}