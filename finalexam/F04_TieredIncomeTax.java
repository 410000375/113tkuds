package finalexam;

import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        long totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = Integer.parseInt(sc.nextLine());
            int tax = calculateTax(income);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }

        long average = totalTax / n;
        System.out.println("Average: $" + average);
        sc.close();
    }

    public static int calculateTax(int income) {
        int tax = 0;
        int[] brackets = {540000, 1210000, 2420000, 4530000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};

        int[] limits = new int[rates.length];
        limits[0] = brackets[0];
        for (int i = 1; i < brackets.length; i++) {
            limits[i] = brackets[i] - brackets[i - 1];
        }
        limits[4] = income - brackets[3]; // 超過最高級距的部分

        int remaining = income;
        for (int i = 0; i < rates.length; i++) {
            int taxable;
            if (i < brackets.length) {
                taxable = Math.min(remaining, limits[i]);
            } else {
                taxable = remaining;
            }

            if (taxable > 0) {
                tax += (int)(taxable * rates[i]);
                remaining -= taxable;
            }

            if (remaining <= 0) break;
        }

        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每筆收入呼叫一次固定時間的稅額計算函式（最多5層級距判斷），
 * 對 n 筆收入各自計算稅額與累加總額，總體時間複雜度為 O(n)。
 */
