public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {           // 列
            for (int j = 0; j < 2; j++) {       // 行
                int sum = 0;
                StringBuilder process = new StringBuilder();
                for (int k = 0; k < 2; k++) {   // 計算每個元素乘積並累加
                    int product = a[i][k] * b[k][j];
                    sum += product;
                    process.append(a[i][k] + "*" + b[k][j]);
                    if (k == 0) {
                        process.append(" + ");
                    }
                }

                // 印出完整的乘法與加總過程
                // 先印出乘法字串，然後印出每個乘積相加
                String[] parts = process.toString().split(" \\+ ");
                StringBuilder productsStr = new StringBuilder();
                for (int p = 0; p < parts.length; p++) {
                    String[] nums = parts[p].split("\\*");
                    int mul = Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
                    productsStr.append(mul);
                    if (p < parts.length - 1) {
                        productsStr.append(" + ");
                    }
                }

                System.out.println("計算位置 c[" + i + "][" + j + "]：" 
                    + process.toString() + " = " + productsStr.toString() + " = " + sum);

                c[i][j] = sum;
            }
        }

        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
    

