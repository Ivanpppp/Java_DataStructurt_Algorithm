package LeetCode;

/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No14 {
    public static void main(String[] args) {
        String[] arr = {"fff","fss","f23"};
        String ans = longestCommonPrefix(arr);
        System.out.println(ans);
    }
    // 按行搜索
    public static String longestCommonPrefix(String[] strs) {
        // 特判
        int n = strs.length;
        if (n == 0){
            return "";
        }
        // 用一个StringBuffer来存放答案，方便后序的字母的添加
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            // 用一个cur来存放当前的一个字符
            char cur = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                // 判断一个终止条件
                // 如果当前字符串的长度比i小，直接退出
                // 如果当前字符串的第i个字母和第一行的不匹配，退出
                if (strs[j].length() <= i || strs[j].charAt(i)!=cur){
                    return ans.toString();
                }
            }
            ans.append(cur);
        }
        return ans.toString();
    }
}
