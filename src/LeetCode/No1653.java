package LeetCode;
/**
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 *
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 *
 * 请你返回使 s 平衡 的 最少 删除次数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 *
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1653 {
    public static void main(String[] args) {

    }
    public int minimumDeletions(String s) {
        // 使用枚举的方法
        int righta = 0;
        int leftb = 0;
        for (char c :
                s.toCharArray()) {
            if (c == 'a') {
                righta++;
            }
        }
        int res = righta;
        for (char c :
                s.toCharArray()) {
            if (c == 'a'){
                righta--;
            }else {
                leftb++;
            }
            res = Math.min(res,leftb+righta);
        }

        return res;
    }
}
