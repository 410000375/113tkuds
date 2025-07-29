package finalexam;

import java.util.Scanner;

public class F08_ClimbStairsMemo {

    public static long climbStairs(int n, long[] memo) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != -1) return memo[n];

        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo) + climbStairs(n - 3, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        long[] memo = new long[n + 1];
        for (int i = 0; i <= n; i++) memo[i] = -1;

        long ways = climbStairs(n, memo);
        System.out.println("Ways: " + ways);
    }
}
