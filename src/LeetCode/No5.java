package LeetCode;

/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No5 {
    public static void main(String[] args) {
        String s = "abccba";
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }
    public static String longestPalindrome(String s) {
        // 特判
        int n = s.length();
        if (n < 2){
            return s;
        }

        int maxLen = 1; // 结果
        int begin = 0;
        // 用dp[i][j]来表示i到j的字串是否为回文串
        boolean[][] dp = new boolean[n][n];
        char[] arr = s.toCharArray();
        
        // 初始化dp
        for (int i = 0; i < n; i++) {
            // 每个单个的字符其实都是回文串
            dp[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i]!=arr[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] == true && j-i+1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
