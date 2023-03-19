package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No784 {
    /**
     * 给定一个字符串s，通过将字符串s中的每个字母转变大小写，我们可以获得一个新的字符串。
     * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
     * 示例 1：
     * 输入：s = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     * 示例 2:
     * 输入: s = "3z4"
     * 输出: ["3z4","3Z4"]
     *
     * @param s
     * @return
     */
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s.toCharArray(),0,ans);
        return ans;
    }

    private void dfs(char[] arr, int pos, List<String> ans) {
        while (pos < arr.length && Character.isDigit(arr[pos])) {
            pos++;
        }
        if (pos == arr.length) {
            ans.add(new String(arr));
            return;
        }
        arr[pos] ^= 32;
        dfs(arr, pos + 1, ans);
        arr[pos] ^= 32;
        dfs(arr, pos + 1, ans);
    }
}
