package midterm;

import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        
        for (int i = 0; i < n; i++) {
            // 讀取分數時乘10轉成整數，避免浮點誤差
            double d = sc.nextDouble();
            scores[i] = (int) Math.round(d * 10);
        }
        
        // 先計算有多少攤位評分是 5.0 (即50)
        int count = 0;
        for (int score : scores) {
            if (score == 50) count++;
        }
        
        if (count == 0) {
            System.out.println("None");
        } else {
            int[] indices = new int[count];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (scores[i] == 50) {
                    indices[idx++] = i;
                }
            }
            // 輸出索引，以空格分隔
            for (int i = 0; i < count; i++) {
                System.out.print(indices[i]);
                if (i < count - 1) System.out.print(" ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}