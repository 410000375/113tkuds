
public class ArrayReversal {
    
static void reverseInPlace(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int swapCount = 0;

        System.out.println("反轉過程：");
        
        while (left < right) {
            System.out.printf("交換索引 %d（值：%d）與索引 %d（值：%d）\n", 
                            left, array[left], right, array[right]);
            
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            swapCount++;
            left++;
            right--;
        }
        
        System.out.printf("總共進行了 %d 次交換\n", swapCount);
    }

    static int[] reverseToNew(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] originalCopy = numbers.clone();

        System.out.println("原始陣列：" + java.util.Arrays.toString(numbers));
        reverseInPlace(numbers);
        System.out.println("原地反轉後：" + java.util.Arrays.toString(numbers));
        int[] newReversed = reverseToNew(originalCopy);
        System.out.println("原始陣列（未修改）：" + java.util.Arrays.toString(originalCopy));
        System.out.println("新反轉陣列：" + java.util.Arrays.toString(newReversed));
    }
}