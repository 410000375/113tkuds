package midterm;

import java.util.Scanner;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] wins = new int[n];
        for (int i = 0; i < n; i++) {
            wins[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] prefix = new int[n + 1]; // prefix[0] = 0
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + wins[i - 1];
        }

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + prefix[i]);
        }
        System.out.println();

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. 建立 prefix sum 陣列需走訪 n 筆資料，時間為 O(n)。
 * 2. 輸出前 k 筆資料也是 O(k)，但 k ≤ n，因此整體仍為 O(n)。
 */
    

