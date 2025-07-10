


import java.util.Arrays;
import java.util.Random;

class LotteryAnalyzer {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 49;
    private static final int MAX_HISTORY = 1000;
    
    private static int[][] lotteryHistory = new int[MAX_HISTORY][LOTTO_SIZE];
    private static int historyCount = 0;
    
    /**
     * 驗證樂透號碼的有效性
     * 檢查：數量、範圍、重複
     */
    static boolean validateLotteryNumbers(int[] numbers) {
        // 檢查數量
        if (numbers.length != LOTTO_SIZE) {
            System.out.printf("錯誤：必須選擇 %d 個號碼，目前有 %d 個\n", 
                            LOTTO_SIZE, numbers.length);
            return false;
        }
        
        // 檢查範圍
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < MIN_NUMBER || numbers[i] > MAX_NUMBER) {
                System.out.printf("錯誤：號碼 %d 超出有效範圍 [%d, %d]\n", 
                                numbers[i], MIN_NUMBER, MAX_NUMBER);
                return false;
            }
        }
        
        // 檢查重複（使用布林陣列進行重複檢測）
        boolean[] used = new boolean[MAX_NUMBER + 1];
        for (int number : numbers) {
            if (used[number]) {
                System.out.printf("錯誤：號碼 %d 重複出現\n", number);
                return false;
            }
            used[number] = true;
        }
        
        System.out.println("樂透號碼有效！");
        return true;
    }
    
    /**
     * 產生隨機樂透號碼
     */
    static int[] generateRandomLottery() {
        Random random = new Random();
        boolean[] used = new boolean[MAX_NUMBER + 1];
        int[] result = new int[LOTTO_SIZE];
        
        System.out.println("產生隨機樂透號碼過程：");
        
        for (int i = 0; i < LOTTO_SIZE; i++) {
            int number;
            do {
                number = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
                System.out.printf("嘗試號碼 %d", number);
            } while (used[number]);
            
            used[number] = true;
            result[i] = number;
            System.out.printf(" → 接受\n");
        }
        
        // 排序號碼（方便閱讀）
        Arrays.sort(result);
        
        return result;
    }
    
    /**
     * 新增樂透開獎記錄
     */
    static boolean addLotteryRecord(int[] numbers) {
        if (!validateLotteryNumbers(numbers)) {
            return false;
        }
        
        if (historyCount >= MAX_HISTORY) {
            System.out.println("警告：歷史記錄已滿，將覆蓋最舊的記錄");
            // 簡單的環形緩衝實作
            historyCount = 0;
        }
        
        // 複製並排序號碼
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        
        System.arraycopy(sortedNumbers, 0, lotteryHistory[historyCount], 0, LOTTO_SIZE);
        historyCount++;
        
        System.out.printf("成功新增第 %d 期開獎記錄：%s\n", 
                        historyCount, Arrays.toString(sortedNumbers));
        return true;
    }
    
    /**
     * 分析號碼出現頻率
     */
    static void analyzeNumberFrequency() {
        if (historyCount == 0) {
            System.out.println("沒有歷史開獎記錄");
            return;
        }
        
        int[] frequency = new int[MAX_NUMBER + 1];
        
        // 統計每個號碼的出現次數
        for (int record = 0; record < historyCount; record++) {
            for (int number : lotteryHistory[record]) {
                frequency[number]++;
            }
        }
        
        System.out.printf("\n=== 號碼出現頻率分析（共 %d 期） ===\n", historyCount);
        
        // 找出最熱門和最冷門的號碼
        int maxFreq = 0;
        int minFreq = historyCount;
        
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            if (frequency[i] > maxFreq) maxFreq = frequency[i];
            if (frequency[i] < minFreq) minFreq = frequency[i];
        }
        
        System.out.printf("理論平均出現次數：%.2f\n", 
                        (double)(historyCount * LOTTO_SIZE) / (MAX_NUMBER - MIN_NUMBER + 1));
        
        System.out.println("\n熱門號碼（出現最多次）：");
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            if (frequency[i] == maxFreq) {
                System.out.printf("號碼 %2d：出現 %d 次\n", i, frequency[i]);
            }
        }
        
        System.out.println("\n冷門號碼（出現最少次）：");
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            if (frequency[i] == minFreq) {
                System.out.printf("號碼 %2d：出現 %d 次\n", i, frequency[i]);
            }
        }
        
        // 顯示完整頻率表
        System.out.println("\n完整頻率表：");
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            System.out.printf("%2d:%2d ", i, frequency[i]);
            if (i % 10 == 0) System.out.println();
        }
        System.out.println();
    }
    
    /**
     * 檢查連號模式
     */
    static void analyzeConsecutivePatterns() {
        if (historyCount == 0) {
            System.out.println("沒有歷史開獎記錄");
            return;
        }
        
        System.out.println("\n=== 連號模式分析 ===");
        
        int[] consecutiveCounts = new int[LOTTO_SIZE];  // 最多可能有 6 個連號
        
        for (int record = 0; record < historyCount; record++) {
            int[] numbers = lotteryHistory[record];
            int maxConsecutive = findMaxConsecutive(numbers);
            
            if (maxConsecutive >= 2) {
                consecutiveCounts[maxConsecutive - 1]++;
                System.out.printf("第 %d 期：%s，最長連號：%d\n", 
                                record + 1, Arrays.toString(numbers), maxConsecutive);
            }
        }
        
        System.out.println("\n連號長度統計：");
        for (int i = 1; i < consecutiveCounts.length; i++) {
            if (consecutiveCounts[i] > 0) {
                System.out.printf("%d 個連號：出現 %d 次\n", i + 1, consecutiveCounts[i]);
            }
        }
    }
    
    /**
     * 找出陣列中最長的連續數字長度
     */
    static int findMaxConsecutive(int[] numbers) {
        if (numbers.length <= 1) return numbers.length;
        
        int maxLength = 1;
        int currentLength = 1;
        
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1] + 1) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        
        return maxLength;
    }
    
    /**
     * 計算兩組號碼的相同個數
     */
    static int countMatches(int[] numbers1, int[] numbers2) {
        int matches = 0;
        
        for (int num1 : numbers1) {
            for (int num2 : numbers2) {
                if (num1 == num2) {
                    matches++;
                    break;
                }
            }
        }
        
        return matches;
    }
    
    /**
     * 模擬中獎機率
     */
    static void simulateWinningProbability(int[] userNumbers, int simulations) {
        if (!validateLotteryNumbers(userNumbers)) {
            return;
        }
        
        System.out.printf("\n=== 中獎機率模擬（%d 次抽籤） ===\n", simulations);
        System.out.println("使用者號碼：" + Arrays.toString(userNumbers));
        
        int[] matchCounts = new int[LOTTO_SIZE + 1];  // 0到6個相同號碼
        
        for (int i = 0; i < simulations; i++) {
            int[] randomNumbers = generateRandomLottery();
            int matches = countMatches(userNumbers, randomNumbers);
            matchCounts[matches]++;
            
            if (matches >= 3) {  // 只顯示3個以上相同的情況
                System.out.printf("第 %d 次：%s，相同號碼：%d 個\n", 
                                i + 1, Arrays.toString(randomNumbers), matches);
            }
        }
        
        System.out.println("\n相同號碼個數統計：");
        for (int i = 0; i <= LOTTO_SIZE; i++) {
            double probability = (double) matchCounts[i] / simulations * 100;
            System.out.printf("%d 個相同：%d 次（%.2f%%）\n", i, matchCounts[i], probability);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== 樂透號碼分析系統 ===");
        
        // 產生一些模擬的歷史開獎資料
        System.out.println("產生模擬歷史開獎資料...");
        for (int i = 0; i < 20; i++) {
            int[] randomLottery = generateRandomLottery();
            addLotteryRecord(randomLottery);
        }
        
        // 分析號碼頻率
        analyzeNumberFrequency();
        
        // 分析連號模式
        analyzeConsecutivePatterns();
        
        // 測試使用者號碼
        int[] userNumbers = {7, 12, 23, 31, 45, 49};
        System.out.println("\n=== 號碼驗證測試 ===");
        validateLotteryNumbers(userNumbers);
        
        // 模擬中獎機率
        simulateWinningProbability(userNumbers, 1000);
        
        // 測試無效號碼
        System.out.println("\n=== 無效號碼測試 ===");
        int[] invalidNumbers1 = {1, 2, 3, 4, 5};  // 數量不足
        int[] invalidNumbers2 = {1, 2, 3, 4, 5, 5};  // 重複號碼
        int[] invalidNumbers3 = {0, 1, 2, 3, 4, 50};  // 超出範圍
        
        validateLotteryNumbers(invalidNumbers1);
        validateLotteryNumbers(invalidNumbers2);
        validateLotteryNumbers(invalidNumbers3);
    }
}
    