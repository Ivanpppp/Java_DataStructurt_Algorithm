package LeetCode;

public class No409 {
    /**
     * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
     * <p>
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入:s = "abccccdd"
     * 输出:7
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     * 示例 2:
     * <p>
     * 输入:s = "a"
     * 输出:1
     * 示例 3：
     * <p>
     * 输入:s = "aaaaaccc"
     * 输出:7
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        // 只有一个字符出现奇数次
        int[] count = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;
        }
        int ans = 0;
        for (int c :
                count) {
            ans += c / 2 * 2;
            if (c % 2 == 1 && ans % 2 == 0) {
                // 判断有没有找到过奇数次数的字符
                // 没有出现过ans必为偶数，否则为奇数
                ans += 1;
            }
        }
        return ans;
    }
}
