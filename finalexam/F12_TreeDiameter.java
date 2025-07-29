package finalexam;

import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int diameter = 0;

    static int height(TreeNode root) {
        if (root == null) return 0;
        int leftH = height(root.left);
        int rightH = height(root.right);
        diameter = Math.max(diameter, leftH + rightH);
        return Math.max(leftH, rightH) + 1;
    }

    public static int treeDiameter(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    
    public static TreeNode buildTree(Scanner sc) {
        int val = sc.nextInt();
        if (val == -1) return null;
        TreeNode root = new TreeNode(val);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!sc.hasNextInt()) break;
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                node.left = new TreeNode(leftVal);
                q.offer(node.left);
            }
            if (!sc.hasNextInt()) break;
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                node.right = new TreeNode(rightVal);
                q.offer(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);
        sc.close();
        System.out.println(treeDiameter(root));
    }
}
