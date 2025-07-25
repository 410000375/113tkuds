import java.util.*;

public class TreeLevelTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // 功能 1：將每一層的節點分別儲存在不同的 List 中
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(currentLevel);
        }

        return result;
    }

    // 功能 2：之字形層序遍歷（Zigzag Level Order）
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    // 功能 3：只印出每一層的最後一個節點
    public static void printRightmostPerLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        System.out.println("每層最後一個節點：");
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode last = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                last = node;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            System.out.println(last.val);
        }
    }

    // 測試用
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("功能 1：層序分層");
        System.out.println(levelOrder(root));

        System.out.println("功能 2：之字形層序遍歷");
        System.out.println(zigzagLevelOrder(root));

        System.out.println("功能 3：每層最後一個節點");
        printRightmostPerLevel(root);
    }
}
