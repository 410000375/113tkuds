public class TreeMirror {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 判斷是否為對稱樹
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    // 比較兩棵樹是否為鏡像
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val &&
               isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }

    // 將一棵樹轉為其鏡像（原地修改）
    public static void mirrorTree(TreeNode root) {
        if (root == null) return;
        // 交換左右子樹
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    // 測試用：中序列印
    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        /*
               1
             /   \
            2     2
           / \   / \
          3  4  4   3
        */
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println("是否對稱: " + isSymmetric(root1));  // true

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println("是否鏡像: " + isMirror(root1.left, root1.right));  // true
        System.out.println("是否鏡像: " + isMirror(root1, root2));            // false

        System.out.println("鏡像前中序：");
        inOrder(root2);
        mirrorTree(root2);
        System.out.println("\n鏡像後中序：");
        inOrder(root2);
    }
}
