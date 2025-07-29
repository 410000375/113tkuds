package finalexam;

import java.util.Scanner;

public class F07_AnagramPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        line = line.toLowerCase();
        int[] freq = new int[26]; // 只統計字母

        for (char c : line.toCharArray()) {
            if (Character.isLetter(c)) {
                freq[c - 'a']++;
            }
        }

        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // 只有一個（或沒有）字母出現奇數次才能重排成回文
        if (oddCount <= 1) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }
}