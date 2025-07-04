import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();             // 陣列長度
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();       // 讀取陣列
        }

        int count = 0;                   // 成對計數
        int ops = 0;                     // 操作次數

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count++;
                ops++;
            }
        }

        System.out.println(count);
        System.out.println(ops);
        sc.close();
    }
}