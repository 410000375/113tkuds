
public class ArraySearcher {
    public static void main(String[] args) {
        int[] numbers = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        int target1 = 67;
        int target2 = 100;

        int index1 = findElement(numbers, target1);
        int index2 = findElement(numbers, target2);

        System.out.println("數字 " + target1 + " 的索引: " + index1);
        System.out.println("數字 " + target2 + " 的索引: " + index2);

        int count1 = countOccurrences(numbers, target1);
        int count2 = countOccurrences(numbers, target2);

        System.out.println("數字 " + target1 + " 出現次數: " + count1);
        System.out.println("數字 " + target2 + " 出現次數: " + count2);
    }

    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int num : array) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
    
