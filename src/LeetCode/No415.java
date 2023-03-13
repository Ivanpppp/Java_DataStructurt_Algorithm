package LeetCode;

public class No415 {
    /**
     * 给定两个字符串形式的非负整数num1 和num2，计算它们的和并同样以字符串形式返回。
     * <p>
     * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：num1 = "11", num2 = "123"
     * 输出："134"
     * 示例 2：
     * <p>
     * 输入：num1 = "456", num2 = "77"
     * 输出："533"
     * 示例 3：
     * <p>
     * 输入：num1 = "0", num2 = "0"
     * 输出："0"
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuffer stringBuffer = new StringBuffer();
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = x + y + add;
            stringBuffer.append(res % 10);
            add = res / 10;
            i--;
            j--;
        }
        return stringBuffer.reverse().toString();
    }
}
