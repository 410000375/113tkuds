
    class TwoDimensionalArrayDemo {
    public static void main(String[] args) {
        int[][] matrix1 = new int[3][4];
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        int[][] jaggedArray = {
            {1, 2},
            {3, 4, 5, 6},
            {7}
        };
        
        System.out.println("=== 矩陣資訊 ===");
        System.out.printf("matrix2 的行數：%d\n", matrix2.length);
        System.out.printf("matrix2 第一行的列數：%d\n", matrix2[0].length);
        
        int value = 1;
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                matrix1[row][col] = value++;
            }
        }
        
        System.out.println("\n=== 矩陣內容 ===");
        System.out.println("matrix1:");
        printMatrix(matrix1);
        
        System.out.println("\nmatrix2:");
        printMatrix(matrix2);
        
        System.out.println("\n鋸齒陣列:");
        printJaggedArray(jaggedArray);
        
        calculateMemoryUsage(matrix2);
    }
    
    static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%4d ", matrix[row][col]);
            }
            System.out.println();
        }
    }
    
    static void printJaggedArray(int[][] jaggedArray) {
        for (int row = 0; row < jaggedArray.length; row++) {
            System.out.printf("第 %d 行：", row);
            for (int col = 0; col < jaggedArray[row].length; col++) {
                System.out.printf("%d ", jaggedArray[row][col]);
            }
            System.out.printf("（長度：%d）\n", jaggedArray[row].length);
        }
    }
    
    static void calculateMemoryUsage(int[][] matrix) {
        int totalElements = 0;
        for (int[] row : matrix) {
            totalElements += row.length;
        }
        
        int bytesPerInt = 4;
        int totalBytes = totalElements * bytesPerInt;
        
        System.out.println("\n=== 記憶體使用分析 ===");
        System.out.printf("總元素數：%d\n", totalElements);
        System.out.printf("記憶體使用量：%d 位元組 = %.2f KB\n", totalBytes, totalBytes / 1024.0);
    }
}
