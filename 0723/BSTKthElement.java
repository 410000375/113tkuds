public class BSTKthElement {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Counter {
        int count = 0;
        int result = -1;
    }

    // 主方法：找到第 k 小的元素
    public static int kthSmallest(TreeNode root, int k) {
        Counter counter = new Counter();
        inorder(root, k, counter);
        return counter.result;
    }

    // 中序遍歷 (左 -> 根 -> 右)，可保證從小到大排序
    private static void inorder(TreeNode node, int k, Counter counter) {
        if (node == null || counter.count >= k) return;

        inorder(node.left, k, counter);
        counter.count++;
        if (counter.count == k) {
            counter.result = node.val;
            return;
        }
        inorder(node.right, k, counter);
    }

    // 測試用
    public static void main(String[] args) {
        /*
                20
               /  \
             10    30
            / \    / \
           5  15  25 35
        */

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        int k = 3;
        System.out.println("第 " + k + " 小的元素是: " + kthSmallest(root, k));  // 應該輸出 15
    }
}
