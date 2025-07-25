public class TreeNodeExample {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
        // 顯示節點資訊
        public void displayNode() {
            System.out.println("節點值: " + data);
            System.out.println("左子節點: " + (left != null ? left.data : "null"));
            System.out.println("右子節點: " + (right != null ? right.data : "null"));
        }
    }
    
    public static void main(String[] args) {
        // 建立節點
        TreeNode root = new TreeNode(10);
        TreeNode leftChild = new TreeNode(5);
        TreeNode rightChild = new TreeNode(15);
        
        // 建立樹的連結
        root.left = leftChild;
        root.right = rightChild;
        
        // 顯示樹的結構
        System.out.println("根節點資訊:");
        root.displayNode();
        
        System.out.println("\n左子節點資訊:");
        leftChild.displayNode();
        
        System.out.println("\n右子節點資訊:");
        rightChild.displayNode();
        
        // 建立更複雜的樹
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        leftChild.left = node1;
        leftChild.right = node2;
        
        System.out.println("\n更新後的左子節點資訊:");
        leftChild.displayNode();
    }
}