public class BSTInsert {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
        }
    }
    
  
    public static TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        
        return root;
    }
    
  
    public static void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = null;
        
      
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        
        for (int value : values) {
            root = insert(root, value);
            System.out.println("插入 " + value);
        }
        
        System.out.print("中序遍歷結果（排序）：");
        inOrder(root);
        System.out.println();
    }
}