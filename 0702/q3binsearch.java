import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();              // 讀取陣列長度
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();         // 讀取已排序陣列
        }

        int key = sc.nextInt();            // 讀取要查找的 key
        int left = 0, right = n - 1;
        int ops = 0;                       // 比較次數
        int result = -1;

        while (left <= right) {
            ops++;
            int mid = (left + right) / 2;
            if (arr[mid] == key) {
                result = mid;
                break;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
        System.out.println(ops);
        sc.close();
    }
}
    

