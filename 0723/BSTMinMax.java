public class BSTMinMax {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
    // 尋找最小值
    public static int findMin(TreeNode root) {
        if (root == null) throw new RuntimeException("樹是空的");
        
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    
    // 尋找最大值
    public static int findMax(TreeNode root) {
        if (root == null) throw new RuntimeException("樹是空的");
        
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
    
    // 插入節點
    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);
        
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        
        return root;
    }
    
    public static void main(String[] args) {
        TreeNode root = null;
        
        // 建立BST
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 90};
        for (int value : values) {
            root = insert(root, value);
        }
        
        System.out.println("最小值: " + findMin(root));
        System.out.println("最大值: " + findMax(root));
    }
}