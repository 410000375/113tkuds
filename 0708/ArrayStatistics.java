
public class ArrayStatistics {
    public static void main(String[] args) {
        int[] data = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0;
        for (int num : data) {
            sum += num;
        }

        double average = (double) sum / data.length;

        int max = data[0], min = data[0];
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
                maxIndex = i;
            }
            if (data[i] < min) {
                min = data[i];
                minIndex = i;
            }
        }

        int countAboveAverage = 0;
        int evenCount = 0;
        int oddCount = 0;
        for (int num : data) {
            if (num > average) {
                countAboveAverage++;
            }
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("+----------------------+----------------+");
        System.out.printf("| %-20s | %-14d |\n", "總和", sum);
        System.out.printf("| %-20s | %-14.2f |\n", "平均值", average);
        System.out.printf("| %-20s | %-14d |\n", "最大值", max);
        System.out.printf("| %-20s | %-14d |\n", "最大值索引", maxIndex);
        System.out.printf("| %-20s | %-14d |\n", "最小值", min);
        System.out.printf("| %-20s | %-14d |\n", "最小值索引", minIndex);
        System.out.printf("| %-20s | %-14d |\n", "大於平均值的數量", countAboveAverage);
        System.out.printf("| %-20s | %-14d |\n", "偶數數量", evenCount);
        System.out.printf("| %-20s | %-14d |\n", "奇數數量", oddCount);
        System.out.println("+----------------------+----------------+");
    }
}
    

