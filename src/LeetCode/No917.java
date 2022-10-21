package LeetCode;

/**
 * 给你一个字符串 s ，根据下述规则反转字符串：
 *
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No917 {
    public static void main(String[] args) {
        String s = reverseOnlyLetters("a-bC-dEf-ghIj");
        System.out.println(s);
    }

    /**
     * 双指针用法
     *  l从左到右
     *  r从右到左
     *  l == r 退出
     * @param s
     * @return
     */
    public static String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0,r = n - 1;
        while (l <= r){
            if (Character.isLetter(chars[l]) && Character.isLetter(chars[r])){
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
            else if (!Character.isLetter(chars[l])){
                l++;
            }
            else if (!Character.isLetter(chars[r])){
                r--;
            }
        }
        return new String(chars);
    }
}
