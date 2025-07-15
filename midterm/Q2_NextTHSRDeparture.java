package midterm;
import java.util.Scanner;

public class Q2_NextTHSRDeparture {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] timeStrings = new String[n];
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            timeStrings[i] = sc.nextLine();
            times[i] = toMinutes(timeStrings[i]);
        }

        String queryStr = sc.nextLine();
        int query = toMinutes(queryStr);

        int idx = binarySearch(times, query);

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(timeStrings[idx]);
        }

        sc.close();
    }

    static int toMinutes(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * - 將時間轉為分鐘數需遍歷 n 筆資料，耗費 O(n)
 * - 使用 binary search 找到第一個大於查詢時間的時間，耗費 O(log n)
 * - 總體時間複雜度為 O(n + log n)，主導項為 O(n)
 */
