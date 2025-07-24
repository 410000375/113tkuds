public class gcd {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;  // 終止條件：b 為 0，a 即為最大公因數
        }
        return gcd(b, a % b);  // 遞迴呼叫
    }

    public static void main(String[] args) {
        int x = 48;
        int y = 18;
        int result = gcd(x, y);
        System.out.println("最大公因數是：" + result);
    }
}
