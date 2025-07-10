
public class FindMaxMin {
    
 public static void main(String[] args) {
        int[] numbers = {45, 23, 67, 89, 12, 34, 78, 56, 91, 38};

        int max = numbers[0];
        int min = numbers[0];
        int maxIndex = 0;
        int minIndex = 0;
        int comparisons = 0;

        for (int i = 1; i < numbers.length; i++) {
            comparisons += 2;

            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
                System.out.printf("發現新的最大值：%d（位置：%d）\n", max, maxIndex);
            }

            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
                System.out.printf("發現新的最小值：%d（位置：%d）\n", min, minIndex);
            }
        }

        System.out.println("\n=== 搜尋結果 ===");
        System.out.printf("陣列大小：%d\n", numbers.length);
        System.out.printf("比較次數：%d\n", comparisons);
        System.out.printf("最大值：%d（索引位置：%d）\n", max, maxIndex);
        System.out.printf("最小值：%d（索引位置：%d）\n", min, minIndex);
        System.out.printf("最大值與最小值的差距：%d\n", max - min);

        int distance = Math.abs(maxIndex - minIndex);
        System.out.printf("最大值與最小值的索引距離：%d\n", distance);
    }
}
