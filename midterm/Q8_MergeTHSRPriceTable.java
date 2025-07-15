package midterm;

import java.util.Scanner;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] stations = new String[n];
        int[][] prices = new int[n][2];  // [][0]=Standard, [][1]=Business
        
        for (int i = 0; i < n; i++) {
            stations[i] = sc.next();
            prices[i][0] = sc.nextInt();
            prices[i][1] = sc.nextInt();
        }
        
        System.out.println("Station|Standard|Business");
        for (int i = 0; i < n; i++) {
            System.out.printf("%s|%d|%d\n", stations[i], prices[i][0], prices[i][1]);
        }
        
        sc.close();
    }
}