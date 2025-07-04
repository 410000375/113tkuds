


    import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取 n
        int n = sc.nextInt();

        // 宣告總和變數
        int sum = 0;

        // 用 O(n) 時間讀取 n 個數並加總
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sum += num;
        }

        // 輸出總和
        System.out.println(sum);

        sc.close();
    }
}
    
