public class TreeComparison {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // ===== 1. 判斷兩棵樹是否完全相同 =====
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // ===== 2. 判斷一棵樹是否是另一棵的子樹 =====
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // ===== 3. 找出兩棵樹的最大公共子樹（回傳節點數量）=====
    public static int largestCommonSubtree(TreeNode root1, TreeNode root2) {
        int[] max = new int[1];
        helper(root1, root2, max);
        return max[0];
    }

    private static int helper(TreeNode n1, TreeNode n2, int[] max) {
        if (n1 == null || n2 == null) return 0;

        if (n1.val == n2.val) {
            int left = helper(n1.left, n2.left, max);
            int right = helper(n1.right, n2.right, max);
            int total = 1 + left + right;
            max[0] = Math.max(max[0], total);
            return total;
        } else {
            // 嘗試從左右子樹繼續比對
            helper(n1.left, n2, max);
            helper(n1.right, n2, max);
            helper(n1, n2.left, max);
            helper(n1, n2.right, max);
            return 0;
        }
    }

    // ===== 測試用 =====
    public static void main(String[] args) {
        // 主樹 root1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        // 子樹 root2
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);

        System.out.println("1. 是否完全相同: " + isSameTree(root1, root2)); // false
        System.out.println("2. 是否為子樹: " + isSubtree(root1, root2));     // true
        System.out.println("3. 最大公共子樹節點數: " + largestCommonSubtree(root1, root2)); // 3
    }
}
