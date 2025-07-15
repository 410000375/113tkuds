package midterm;
import java.util.Scanner;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 讀取停靠站數
        String[] stations = new String[n];

        for (int i = 0; i < n; i++) {
            stations[i] = sc.next();
        }

        String start = sc.next();
        String end = sc.next();

        int startIdx = -1;
        int endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) startIdx = i;
            if (stations[i].equals(end)) endIdx = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            int stops = Math.abs(startIdx - endIdx) + 1;
            System.out.println(stops);
            sc.close();
            
        }
    }
}
 /*
             * Time Complexity: O(n)
             * 說明：
             * - 使用一次 for 迴圈走訪 n 個停靠站，找出起點與終點索引。
             * - 其他操作皆為常數時間，因此總體時間複雜度為 O(n)。
             */