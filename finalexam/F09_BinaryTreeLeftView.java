package finalexam;

import java.util.*;

public class F09_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode buildTree(List<Integer> vals) {
        if (vals.isEmpty() || vals.get(0) == -1) return null;

        TreeNode root = new TreeNode(vals.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < vals.size()) {
            TreeNode current = queue.poll();
            if (current == null) break;

            // 左子
            if (i < vals.size() && vals.get(i) != -1) {
                current.left = new TreeNode(vals.get(i));
                queue.add(current.left);
            }
            i++;

            // 右子
            if (i < vals.size() && vals.get(i) != -1) {
                current.right = new TreeNode(vals.get(i));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 第一個節點為左視圖
            result.add(queue.peek().val);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> vals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vals.add(sc.nextInt());
        }
        sc.close();

        TreeNode root = buildTree(vals);
        List<Integer> leftViewNodes = leftView(root);

        System.out.print("LeftView:");
        for (int v : leftViewNodes) {
            System.out.print(" " + v);
        }
        System.out.println();
    }
}

