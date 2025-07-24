public class digitSum {
    public static int sumDigits(int n) {
        if (n < 10) return n;
        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        int result = sumDigits(12345);
        System.out.println(result);  // 輸出：15
    }
}

