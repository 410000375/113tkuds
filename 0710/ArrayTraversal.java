
public class ArrayTraversal { public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("方法一：傳統 for 迴圈（需要索引時使用）");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("索引 %d：值 %d，記憶體相對位址：%d\n", 
                            i, numbers[i], i * 4);
        }
        
        System.out.println("\n方法二：增強型 for 迴圈（只需要值時使用）");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            System.out.println("目前處理的值：" + num + "，累計總和：" + sum);
        }
        
        System.out.println("\n方法三：反向走訪");
        System.out.print("反向輸出：");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i > 0) System.out.print(" -> ");
        }
        System.out.println();
        
        System.out.println("\n方法四：跳躍式走訪");
        System.out.print("偶數索引的元素：");
        for (int i = 0; i < numbers.length; i += 2) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
    

