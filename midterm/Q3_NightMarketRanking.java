package midterm;

import java.util.Scanner;

public class Q3_NightMarketRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextDouble();
        }

        // 選擇排序由大到小
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIndex]) {
                    maxIndex = j;
                }
            }
            // 交換
            double temp = scores[i];
            scores[i] = scores[maxIndex];
            scores[maxIndex] = temp;
        }

        // 輸出前 5 名
        int outputCount = Math.min(5, n);
        for (int i = 0; i < outputCount; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n²)
 * 說明：
 * 1. 外層迴圈跑 n-1 次，內層跑 n-i-1 次，總比較次數為 n(n-1)/2。
 * 2. 交換次數最多為 n-1 次，但不影響主時間複雜度。
 * 3. 適合用於資料量不大的排序場景。
 */

