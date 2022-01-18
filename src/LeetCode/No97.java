package LeetCode;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/interleaving-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No97 {
    public static void main(String[] args) {

    }

    /**
     * 动态规划
     * 状态方程为 f(i,j) = f(i-1,j)&&s.charAt(p)==s1(i-1) ||  f(i,j-1)&&s.charAt(p)==s2(j-1)
     * f(i,j)表示s1前i个和s2前j个字母是否能实现s3前i+j位排列
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(),m = s2.length(),p = s3.length();
        if (n+m != p){
            return false;
        }
        boolean[][] f = new boolean[n+1][m+1];
        f[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int t = i + j - 1;
                if (i > 0){
                    f[i][j] = f[i][j] || (f[i-1][j] && s3.charAt(t) == s1.charAt(i - 1));
                }
                if (j > 0){
                    f[i][j] = f[i][j] || (f[i][j-1] && s3.charAt(t) == s2.charAt(j - 1));
                }
            }
        }
        return f[n][m];
    }
}
