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
说明:

所有输入只包含小写字母 a-z 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No14 {
    public static void main(String[] args) {

    }

    public static String longestCommonPrefix(String[] strs) {
        // 特判
        if (strs.length == 0){
            return "";
        }
        // 对于所有的字符串，首先比较第一个字母，再比较第二个字母，以此类推
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                char cur = strs[0].charAt(i);
                if (strs[j].length() < i){
                    return ans.toString();
                }
                if (strs[j].charAt(i) == cur){
                    continue;
                }else {
                    return ans.toString();
                }
            }
            // 如果所有的字符串的第一个字母都一样，ans.append（该字母）
            ans.append(strs[0].charAt(i));
        }
        return ans.toString();
    }
}
