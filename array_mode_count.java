public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};
        int mode = arr[0];     // 預設眾數
        int maxCount = 0;      // 出現次數最多

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            // 對 arr[i] 進行比對，看它出現幾次
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            // 印出比對過程
            System.out.println("比對中：" + arr[i] + " 出現次數 = " + count);

            // 更新目前的眾數與最大次數
            if (count > maxCount) {
                maxCount = count;
                mode = arr[i];
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}

