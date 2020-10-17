package LeetCode;

/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10001));
    }

    public static boolean isPalindrome(int x) {
        // 如果是负数直接返回即可
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        // 翻转一半数字
        int reversedNum = 0;
        while (x > reversedNum) {
            reversedNum = reversedNum * 10 + x % 10;
            x /= 10;
        }
        // 翻转结束后直接判断是否一样即可，如果是偶数则判断直接相等，如果是奇数则需要去除最后一位数字
        return x == reversedNum || x == reversedNum / 10;
    }
}