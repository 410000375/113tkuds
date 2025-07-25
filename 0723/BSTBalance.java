public class BSTBalance {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // 檢查是否為平衡樹
    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    // 回傳子樹高度，若不平衡則回傳 -1
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;  // 左子樹不平衡

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // 右子樹不平衡

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;  // 本節點不平衡

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 計算節點的平衡因子
    public static int getBalanceFactor(TreeNode node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // 找出最不平衡的節點（平衡因子絕對值最大）
    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        return findMostUnbalancedNodeHelper(root, new TreeNode[1], new int[]{-1});
    }

    // 用陣列來記錄目前最大不平衡節點與其平衡因子絕對值
    private static TreeNode findMostUnbalancedNodeHelper(TreeNode node, TreeNode[] maxNode, int[] maxAbsBalance) {
        if (node == null) return null;

        int balance = Math.abs(getBalanceFactor(node));
        if (balance > maxAbsBalance[0]) {
            maxAbsBalance[0] = balance;
            maxNode[0] = node;
        }

        findMostUnbalancedNodeHelper(node.left, maxNode, maxAbsBalance);
        findMostUnbalancedNodeHelper(node.right, maxNode, maxAbsBalance);

        return maxNode[0];
    }

    // ===== 測試 =====
    public static void main(String[] args) {
        /*
              10
             /  \
            5    20
           /    /  \
          2    15  30
         / 
        1
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(30);

        System.out.println("BST是否為平衡樹？ " + (isBalanced(root) ? "是" : "否"));

        TreeNode mostUnbalanced = findMostUnbalancedNode(root);
        if (mostUnbalanced != null) {
            System.out.println("最不平衡節點值：" + mostUnbalanced.val);
            System.out.println("該節點平衡因子：" + getBalanceFactor(mostUnbalanced));
        } else {
            System.out.println("樹中沒有節點");
        }
    }
}
