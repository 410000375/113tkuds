
public class ArrayUtility {
public static void main(String[] args) {
        int[] data = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.print("原始陣列: ");
        printArray(data);

        reverseArray(data);
        System.out.print("反轉後陣列: ");
        printArray(data);

        int[] copy = copyArray(data);
        System.out.print("複製陣列: ");
        printArray(copy);

        int secondLargest = findSecondLargest(data);
        System.out.println("第二大值: " + secondLargest);
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void reverseArray(int[] array) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second && num < max) {
                second = num;
            }
        }
        return second;
    }
}
    

