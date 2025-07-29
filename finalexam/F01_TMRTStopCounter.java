package finalexam;
import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        List<String> stations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stations.add(sc.next());
        }

        String start = sc.next(); 
        String end = sc.next();   

        int idx1 = -1, idx2 = -1;

        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).equals(start)) {
                idx1 = i;
            }
            if (stations.get(i).equals(end)) {
                idx2 = i;
            }
        }

        if (idx1 == -1 || idx2 == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(idx1 - idx2) + 1);
        }

        sc.close();
    }
}

/*
 * Time Complexity: O(n)
 * 說明：需掃描一次長度為 n 的停靠站序列以找出起點與終點的索引位置，
 * 每個元素只檢查一次，因此時間複雜度為 O(n)，其中 n 為輸入的停靠站數。
 */
