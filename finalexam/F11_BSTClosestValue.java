package finalexam;

import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static int closestValue(TreeNode root, int target) {
        int closest = root.val;
        TreeNode node = root;
        while (node != null) {
            if (Math.abs(node.val - target) < Math.abs(closest - target) ||
                (Math.abs(node.val - target) == Math.abs(closest - target) && node.val < closest)) {
                closest = node.val;
            }
            if (target < node.val) node = node.left;
            else if (target > node.val) node = node.right;
            else break; // exact match
        }
        return closest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            root = insert(root, val);
        }
        int target = sc.nextInt();
        sc.close();

        System.out.println(closestValue(root, target));
    }
}
