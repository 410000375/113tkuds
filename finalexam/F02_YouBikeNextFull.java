package finalexam;

import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];  
        for (int i = 0; i < n; i++) {
            times[i] = toMinutes(sc.nextLine());
        }

        int queryTime = toMinutes(sc.nextLine());

        int index = binarySearch(times, queryTime);

        if (index == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(toHHmm(times[index]));
        }

        sc.close();
    }

    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static String toHHmm(int minutes) {
        int hh = minutes / 60;
        int mm = minutes % 60;
        return String.format("%02d:%02d", hh, mm);
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋在已排序陣列中查找下一個有車時間，
 * 每次將搜尋範圍減半，因此時間複雜度為 O(log n)。
 */
