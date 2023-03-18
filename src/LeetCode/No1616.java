package LeetCode;

public class No1616 {
    /**
     * 给你两个字符串a 和b，它们长度相同。请你选择一个下标，将两个字符串都在相同的下标 分割开。由a可以得到两个字符串：aprefix和asuffix，满足a = aprefix + asuffix，同理，由b 可以得到两个字符串bprefix 和bsuffix，满足b = bprefix + bsuffix。请你判断aprefix + bsuffix 或者bprefix + asuffix能否构成回文串。
     * 当你将一个字符串s分割成sprefix 和ssuffix时，ssuffix 或者sprefix 可以为空。比方说，s = "abc"那么"" + "abc"，"a" + "bc"，"ab" + "c"和"abc" + ""都是合法分割。
     * 如果 能构成回文字符串 ，那么请返回true，否则返回false。
     * 注意，x + y表示连接字符串x 和y。
     * 示例 1：
     * 输入：a = "x", b = "y"
     * 输出：true
     * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
     * aprefix = "", asuffix = "x"
     * bprefix = "", bsuffix = "y"
     * 那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
     *
     * @param a
     * @param b
     * @return
     */
    public boolean checkPalindromeFormation(String a, String b) {
        return checkConcatenation(a,b) || checkConcatenation(b,a);
    }

    public boolean checkConcatenation(String a, String b) {
        int n = a.length();
        int l = 0, r = n - 1;
        while (l < r && a.charAt(l) == b.charAt(r)){
            l++;
            r--;
        }
        if (l >= r) {
            return true;
        }
        return checkSelfPalindrome(a,l,r) || checkSelfPalindrome(b,l,r);
    }

    public boolean checkSelfPalindrome(String a,int left,int right){
        while (left <= right && a.charAt(left) == a.charAt(right)){
            left++;
            right--;
        }
        return left >= right;
    }

}
