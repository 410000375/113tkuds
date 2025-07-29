package finalexam;

import java.util.Scanner;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcdRecursive(a, b);
        int lcm = a * b / gcd;
        System.out.println("LCM: " + lcm);
        sc.close();
    }

    public static int gcdRecursive(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcdRecursive(a - b, b);
        else return gcdRecursive(a, b - a);
    }
}

/*
 * Time Complexity: O(max(a, b))
 * 說明：使用輾轉**相減法**求 GCD，最差情況下每次僅減 1，遞迴深度為 max(a, b)，
 * 因此時間複雜度為 O(max(a, b))。與除法版歐幾里得算法 O(log n) 相比較慢。
 */
