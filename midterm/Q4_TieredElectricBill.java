package midterm;

    import java.util.Scanner;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bills = new int[n];  // 存每筆電費

        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            int bill = calc(kWh);
            bills[i] = bill;
            total += bill;
        }

        for (int bill : bills) {
            System.out.println("Bill: $" + bill);
        }

        int average = Math.round((float) total / n);

        System.out.println("Total: $" + total);
        System.out.println("Average: $" + average);

        sc.close();
    }

    static int calc(int kWh) {
        double cost = 0;

        if (kWh > 1000) {
            cost += (kWh - 1000) * 8.46;
            kWh = 1000;
        }
        if (kWh > 700) {
            cost += (kWh - 700) * 6.24;
            kWh = 700;
        }
        if (kWh > 500) {
            cost += (kWh - 500) * 5.04;
            kWh = 500;
        }
        if (kWh > 330) {
            cost += (kWh - 330) * 3.70;
            kWh = 330;
        }
        if (kWh > 120) {
            cost += (kWh - 120) * 2.45;
            kWh = 120;
        }
        cost += kWh * 1.68;

        return (int) Math.round(cost);  // 四捨五入取整
    }
}

/*
 * Time Complexity: O(n)
 * 說明：
 * 1. 主程式對每筆用電量呼叫一次 calc() 方法，總共呼叫 n 次。
 * 2. calc() 中為固定層數的條件判斷與簡單減法與乘法，視為 O(1)。
 * 3. 整體為 O(n)。
 */
    

