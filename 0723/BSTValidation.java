import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 功能 1：驗證是否為合法 BST
    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }

    // 功能 2：找出不符合 BST 規則的節點
    public static List<TreeNode> findInvalidNodes(TreeNode root) {
        List<TreeNode> invalidNodes = new ArrayList<>();
        findInvalid(root, null, null, invalidNodes);
        return invalidNodes;
    }

    private static void findInvalid(TreeNode node, Integer min, Integer max, List<TreeNode> invalidNodes) {
        if (node == null) return;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            invalidNodes.add(node);
        }
        findInvalid(node.left, min, node.val, invalidNodes);
        findInvalid(node.right, node.val, max, invalidNodes);
    }

    // 功能 3：計算最少要移除多少個節點才能變成合法 BST
    public static int minRemovalsToBST(TreeNode root) {
        return countRemovals(root, null, null);
    }

    private static int countRemovals(TreeNode node, Integer min, Integer max) {
        if (node == null) return 0;
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            // 若節點不合法，整棵子樹要被移除（或者忽略）
            // 這裡保守計算為 1 + 所有子節點都移除
            return 1 + countAllNodes(node);
        }
        return countRemovals(node.left, min, node.val) + countRemovals(node.right, node.val, max);
    }

    // 計算某個子樹的所有節點數量
    private static int countAllNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }

    // 測試
    public static void main(String[] args) {
        /*
            測試樹：
                  10
                 /  \
                5    8   <-- 8 應該在左子樹，但放在右邊 => 不合法 BST
               / \
              2   7
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8); // 錯誤節點（應該 > 10）
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);

        System.out.println("功能 1：是否為合法 BST？");
        System.out.println(isValidBST(root));  // false

        System.out.println("\n功能 2：不合法節點如下（值）：");
        List<TreeNode> invalids = findInvalidNodes(root);
        for (TreeNode node : invalids) {
            System.out.println(node.val);
        }

        System.out.println("\n功能 3：最少要移除多少節點才能變合法 BST？");
        System.out.println(minRemovalsToBST(root));  // 1
    }
}
