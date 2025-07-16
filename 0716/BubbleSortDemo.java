
   
class BubbleSortDemo {
    static void bubbleSort(int[] array) {
        int n = array.length;
        int totalComparisons = 0;
        int totalSwaps = 0;
        
        System.out.println("氣泡排序過程：");
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            int roundComparisons = 0;
            int roundSwaps = 0;
            
            System.out.printf("\n第 %d 輪排序：\n", i + 1);
            
            for (int j = 0; j < n - i - 1; j++) {
                roundComparisons++;
                totalComparisons++;
                
                System.out.printf("比較 array[%d]=%d 與 array[%d]=%d ", 
                                j, array[j], j + 1, array[j + 1]);
                
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    
                    swapped = true;
                    roundSwaps++;
                    totalSwaps++;
                    System.out.println("→ 交換");
                } else {
                    System.out.println("→ 不交換");
                }
            }
            
            System.out.printf("第 %d 輪結束：比較 %d 次，交換 %d 次\n", 
                            i + 1, roundComparisons, roundSwaps);
            System.out.println("目前陣列：" + java.util.Arrays.toString(array));
            
            if (!swapped) {
                System.out.println("提早結束：陣列已經排序完成");
                break;
            }
        }
        
        System.out.printf("\n排序完成！總比較次數：%d，總交換次數：%d\n", 
                        totalComparisons, totalSwaps);
    }

    static void cocktailSort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        boolean swapped = true;
        
        System.out.println("\n雞尾酒排序過程：");
        
        while (swapped && left < right) {
            swapped = false;
            
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            right--;
            
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
            left++;
            
            System.out.println("目前陣列：" + java.util.Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] numbers1 = {64, 34, 25, 12, 22, 11, 90};
        int[] numbers2 = numbers1.clone();
        
        System.out.println("原始陣列：" + java.util.Arrays.toString(numbers1));
        
        System.out.println("\n=== 基本氣泡排序 ===");
        bubbleSort(numbers1);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers1));
        
        System.out.println("\n=== 雞尾酒排序 ===");
        cocktailSort(numbers2);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers2));
    }
}