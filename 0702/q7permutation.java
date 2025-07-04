import java.util.Scanner;

public class q7permutation {
    static int ops = 0;         // 計算總排列數
    static int n;
    static boolean[] used;
    static int[] perm;

    public static void dfs(int depth) {
        if (depth == n) {
            ops++;
            for (int i = 0; i < n; i++) {
                System.out.print(perm[i]);
                if (i != n - 1) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[depth] = i;
                dfs(depth + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        used = new boolean[n + 1]; 
        perm = new int[n];

        dfs(0);

        System.out.println(ops);
        sc.close();
    }
}