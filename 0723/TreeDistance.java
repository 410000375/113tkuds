import java.util.*;

public class TreeDistance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 計算兩節點距離：distance(a,b) = depth(a) + depth(b) - 2 * depth(LCA(a,b))
    public static int distance(TreeNode root, TreeNode a, TreeNode b) {
        TreeNode lca = findLCA(root, a, b);
        int distA = depth(root, a, 0);
        int distB = depth(root, b, 0);
        int distLCA = depth(root, lca, 0);
        return distA + distB - 2 * distLCA;
    }

    // 找最近共同祖先 (LCA)
    public static TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || root == a || root == b) return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // 計算節點深度 (root深度為0)
    public static int depth(TreeNode root, TreeNode target, int d) {
        if (root == null) return -1;
        if (root == target) return d;

        int left = depth(root.left, target, d + 1);
        if (left != -1) return left;

        return depth(root.right, target, d + 1);
    }

    // 找樹的直徑 (兩節點間的最大距離)
    public static int treeDiameter(TreeNode root) {
        int[] diameter = new int[1];
        heightForDiameter(root, diameter);
        return diameter[0];
    }

    private static int heightForDiameter(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        int leftHeight = heightForDiameter(node.left, diameter);
        int rightHeight = heightForDiameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 找出距離根節點指定距離的所有節點
    public static List<Integer> nodesAtDistance(TreeNode root, int distance) {
        List<Integer> result = new ArrayList<>();
        collectNodesAtDistance(root, distance, 0, result);
        return result;
    }

    private static void collectNodesAtDistance(TreeNode node, int targetDist, int currentDist, List<Integer> result) {
        if (node == null) return;
        if (currentDist == targetDist) {
            result.add(node.val);
            return;
        }
        collectNodesAtDistance(node.left, targetDist, currentDist + 1, result);
        collectNodesAtDistance(node.right, targetDist, currentDist + 1, result);
    }

    // ===== 測試範例 =====
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
               /
              7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);

        TreeNode node4 = root.left.left;      // 4
        TreeNode node7 = root.left.right.left; // 7

        System.out.println("節點 4 與節點 7 之距離：" + distance(root, node4, node7));

        System.out.println("樹的直徑：" + treeDiameter(root));

        int targetDist = 2;
        List<Integer> nodes = nodesAtDistance(root, targetDist);
        System.out.println("距離根節點 " + targetDist + " 的節點有：" + nodes);
    }
}
