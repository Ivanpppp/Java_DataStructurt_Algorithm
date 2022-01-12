package LeetCode;

/**
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2：
 *
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *  
 *
 * 提示：
 *
 * 1 <= num.length <= 35
 * num 仅由数字（0 - 9）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No306 {
    public static void main(String[] args) {

    }
    public boolean isAdditiveNumber(String num) {
        // 穷举法 O(n^3)
        int n = num.length();
        for (int secondStart = 1; secondStart < n - 1; secondStart++) {
            if (num.charAt(secondStart) == '0' && secondStart != 1) break;
            for (int secondEnd = secondStart; secondEnd < n - 1; secondEnd++) {
                if (num.charAt(secondEnd) == '0' && secondEnd != secondStart) break;
                if (valid(secondStart,secondEnd,num)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean valid(int secondStart, int secondEnd, String num) {
        int n = num.length();
        int firstStart = 0,firstEnd = secondStart - 1;
        while (secondEnd <= n - 1){
            String third = StringAdd(firstStart,firstEnd,secondStart,secondEnd,num);
            int thirdStart = secondEnd + 1;
            int thirdEnd = secondEnd + third.length();
            if (thirdEnd >= n || !num.substring(thirdStart,thirdEnd+1).equals(third)){
                break;
            }
            if (thirdEnd == n - 1) {
                return true;
            }
            firstEnd = secondEnd;
            firstStart = secondStart;
            secondStart = thirdStart;
            secondEnd = thirdEnd;
        }
        return false;
    }

    private String StringAdd(int firstStart, int firstEnd, int secondStart, int secondEnd, String num) {
        StringBuffer stringBuffer = new StringBuffer();
        int cur = 0,carry = 0;
        while (firstEnd >= firstStart || secondStart <= secondEnd || carry != 0){
            cur = carry;
            if (firstEnd >= firstStart){
                cur += num.charAt(firstEnd) - '0';
                firstEnd--;
            }
            if (secondEnd >= secondStart){
                cur += num.charAt(secondEnd) - '0';
                secondEnd--;
            }
            carry = cur / 10;
            cur %= 10;
            stringBuffer.append((char) (cur +'0'));
        }
        stringBuffer.reverse();
        return stringBuffer.toString();
    }
}
