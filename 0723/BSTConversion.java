public class BSTConversion {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // ===== 1. BST ➜ 排序的雙向鏈表 =====
    static class DoublyListNode {
        int val;
        DoublyListNode prev, next;
        DoublyListNode(int val) {
            this.val = val;
        }
    }

    private static DoublyListNode head = null;
    private static DoublyListNode prev = null;

    public static DoublyListNode bstToDoublyList(TreeNode root) {
        head = null;
        prev = null;
        inOrderConvert(root);
        return head;
    }

    private static void inOrderConvert(TreeNode node) {
        if (node == null) return;

        inOrderConvert(node.left);

        DoublyListNode curr = new DoublyListNode(node.val);
        if (prev == null) {
            head = curr;
        } else {
            prev.next = curr;
            curr.prev = prev;
        }
        prev = curr;

        inOrderConvert(node.right);
    }

    // ===== 2. 排序陣列 ➜ 平衡 BST =====
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBalancedBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBalancedBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBalancedBST(nums, left, mid - 1);
        root.right = buildBalancedBST(nums, mid + 1, right);
        return root;
    }

    // ===== 3. 節點值 ➜ 所有大於等於該節點值的總和 =====
    private static int sum = 0;

    public static void convertToGreaterSumTree(TreeNode root) {
        sum = 0;
        reverseInOrder(root);
    }

    private static void reverseInOrder(TreeNode node) {
        if (node == null) return;

        reverseInOrder(node.right);
        sum += node.val;
        node.val = sum;
        reverseInOrder(node.left);
    }

    // ===== 輔助函式：中序列印 BST =====
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // ===== 輔助函式：列印雙向鏈表 =====
    public static void printDoublyList(DoublyListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" <-> ");
            node = node.next;
        }
        System.out.println();
    }

    // ===== 測試主程式 =====
    public static void main(String[] args) {
        // 測試用 BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("1. BST 轉雙向鏈表：");
        DoublyListNode list = bstToDoublyList(root);
        printDoublyList(list); // 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> 6 <-> 7

        System.out.println("\n2. 排序陣列轉平衡 BST：");
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode balanced = sortedArrayToBST(nums);
        printInOrder(balanced); // 印出中序：-10 -3 0 5 9

        System.out.println("\n\n3. BST 轉 Greater Sum Tree：");
        convertToGreaterSumTree(root);
        printInOrder(root); // 28 27 25 22 18 13 7（或其他相對結果）
    }
}
