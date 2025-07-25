import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // ===== 1. 用前序 + 中序 重建二元樹 =====
    public static TreeNode buildTreeFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int preL, int preR, int[] in, int inL, int inR, Map<Integer, Integer> inMap) {
        if (preL > preR) return null;
        int rootVal = pre[preL];
        TreeNode root = new TreeNode(rootVal);
        int inRootIdx = inMap.get(rootVal);
        int leftSize = inRootIdx - inL;

        root.left = buildPreIn(pre, preL + 1, preL + leftSize, in, inL, inRootIdx - 1, inMap);
        root.right = buildPreIn(pre, preL + leftSize + 1, preR, in, inRootIdx + 1, inR, inMap);
        return root;
    }

    // ===== 2. 用後序 + 中序 重建二元樹 =====
    public static TreeNode buildTreeFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] post, int postL, int postR, int[] in, int inL, int inR, Map<Integer, Integer> inMap) {
        if (postL > postR) return null;
        int rootVal = post[postR];
        TreeNode root = new TreeNode(rootVal);
        int inRootIdx = inMap.get(rootVal);
        int leftSize = inRootIdx - inL;

        root.left = buildPostIn(post, postL, postL + leftSize - 1, in, inL, inRootIdx - 1, inMap);
        root.right = buildPostIn(post, postL + leftSize, postR - 1, in, inRootIdx + 1, inR, inMap);
        return root;
    }

    // ===== 3. 驗證用：中序遍歷印出結果 =====
    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    // ===== 測試區 =====
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        System.out.println("從前序 + 中序重建後的中序遍歷：");
        TreeNode root1 = buildTreeFromPreIn(preorder, inorder);
        printInOrder(root1); // 應為 9 3 15 20 7
        System.out.println();

        System.out.println("從後序 + 中序重建後的中序遍歷：");
        TreeNode root2 = buildTreeFromPostIn(postorder, inorder);
        printInOrder(root2); // 應為 9 3 15 20 7
        System.out.println();
    }
}