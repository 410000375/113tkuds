package midterm;

import java.util.Scanner;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        char[][] map = new char[10][10];
        // 先填滿 #
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = '#';
            }
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            // 檢查範圍
            if (r >= 0 && r < 10 && c >= 0 && c < 10) {
                map[r][c] = '*';
            }
        }

        // 輸出地圖
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}