package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No763 {
    /**
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     * 返回一个表示每个字符串片段的长度的列表。
     * 示例 1：
     * 输入：s = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
     * 示例 2：
     * 输入：s = "eccbbbbdec"
     * 输出：[10]
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] = i; //获取每个字符最后出现的位置
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0,end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end,arr[s.charAt(i)-'a']);
            if (i == end){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[26];
        String s = "ebcdabcd";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            System.out.printf("s.charAt(i)："+s.charAt(i)+"   位置为"+(s.charAt(i) - 'a'));
            arr[s.charAt(i) - 'a'] = i; //获取每个字符最后出现的位置
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
