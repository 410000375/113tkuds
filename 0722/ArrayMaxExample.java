public class ArrayMaxExample {
    
    public static int findMax(int[] arr, int index) {
        // 停止條件：到達最後一個元素
        if (index == arr.length - 1) {
            return arr[index];
        }
        // 遞迴關係：當前元素與剩餘最大值比較
        int maxOfRest = findMax(arr, index + 1);
        return Math.max(arr[index], maxOfRest);
    }
    
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, 9, 1};
        System.out.println("最大值: " + findMax(numbers, 0)); // 輸出：9
        
        int[] moreNumbers = {15, 8, 23, 4};
        System.out.println("最大值: " + findMax(moreNumbers, 0)); // 輸出：23
    }
}