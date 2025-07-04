import java.util.Scanner;

public class q6fibonaccirec {
    static int ops = 0; // 統計遞迴呼叫次數

    public static int fibo(int n) {
        ops++;
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = fibo(n);
        System.out.println(result);
        System.out.println(ops);
        sc.close();
    }
}