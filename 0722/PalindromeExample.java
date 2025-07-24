public class PalindromeExample {
    
    public static boolean isPalindrome(String str, int start, int end) {
        // 停止條件：檢查完所有字符
        if (start >= end) {
            return true;
        }
        // 如果首尾字符不同，不是回文
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // 遞迴檢查中間部分
        return isPalindrome(str, start + 1, end - 1);
    }
    
    public static void main(String[] args) {
        String word1 = "racecar";
        System.out.println(word1 + " 是回文嗎？ " + 
                          isPalindrome(word1, 0, word1.length() - 1)); // true
        
        String word2 = "hello";
        System.out.println(word2 + " 是回文嗎？ " + 
                          isPalindrome(word2, 0, word2.length() - 1)); // false
    }
}