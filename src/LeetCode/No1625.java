package LeetCode;

public class No1625 {
    /**
     * 给你一个字符串 s 以及两个整数 a 和 b 。其中，字符串 s 的长度为偶数，且仅由数字 0 到 9 组成。
     * 你可以在 s 上按任意顺序多次执行下面两个操作之一：
     * 累加：将  a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。数字一旦超过 9 就会变成 0，如此循环往复。例如，s = "3456" 且 a = 5，则执行此操作后 s 变成 "3951"。
     * 轮转：将 s 向右轮转 b 位。例如，s = "3456" 且 b = 1，则执行此操作后 s 变成 "6345"。
     * 请你返回在 s 上执行上述操作任意次后可以得到的 字典序最小 的字符串。
     * 如果两个字符串长度相同，那么字符串 a 字典序比字符串 b 小可以这样定义：在 a 和 b 出现不同的第一个位置上
     * 字符串 a 中的字符出现在字母表中的时间早于 b 中的对应字符。例如，"0158” 字典序比 "0190" 小，因为不同的第一个位置是在第三个字符，显然 '5' 出现在 '9' 之前。
     *
     * @param s
     * @param a
     * @param b
     * @return
     */
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        boolean[] vis = new boolean[n];
        String res = s;
        // 将 s 延长一倍，方便截取轮转后的字符串 t
        s = s + s;
        for (int i = 0; !vis[i]; i = (i + b) % n) {
            vis[i] = true;
            for (int j = 0; j < 10; j++) {
                int kLimit = b % 2 == 0 ? 0 : 9;
                for (int k = 0; k <= kLimit; k++) {
                    // 每次进行累加之前，重新截取 t
                    char[] t = s.substring(i, i + n).toCharArray();
                    for (int p = 1; p < n; p += 2) {
                        t[p] = (char) ('0' + (t[p] - '0' + j * a) % 10);
                    }
                    for (int p = 0; p < n; p += 2) {
                        t[p] = (char) ('0' + (t[p] - '0' + k * a) % 10);
                    }
                    String tStr = new String(t);
                    if (tStr.compareTo(res) < 0) {
                        res = tStr;
                    }
                }
            }
        }
        return res;
    }

}
