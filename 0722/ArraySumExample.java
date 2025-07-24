public class ArraySumExample {
    
    public static int arraySum(int[] arr, int index) {
        // 停止條件：超出陣列範圍
        if (index >= arr.length) {
            return 0;
        }
        // 遞迴關係：當前元素 + 剩餘元素總和
        return arr[index] + arraySum(arr, index + 1);
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("陣列總和: " + arraySum(numbers, 0)); // 輸出：15
        
        int[] moreNumbers = {10, 20, 30};
        System.out.println("陣列總和: " + arraySum(moreNumbers, 0)); // 輸出：60
    }
}