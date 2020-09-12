package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No6 {
    public static void main(String[] args) {
        String test = "LEETCODENO6";
        int n = 4;
        String ans = convert(test,n);
        System.out.println(ans);
    }
    public static String convert(String s, int numRows) {
        // 按行来做
        // 特判
        if (numRows == 1) return s;
        // 先声明Math.min(s.length(),numRows)的行数 —— 如果声明numRows的行数，但numRows行数比s.length大，就会出错
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(),numRows); i++) {
            // 初始化rows
            rows.add(new StringBuffer());
        }

        // 判断每次的移动
        int curRow = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            rows.get(curRow).append(cur);
            if(curRow == 0 || curRow == numRows - 1){
                // 改变方向
                flag = !flag;
            }
            curRow += flag?1:-1;
        }
        StringBuffer ans = new StringBuffer();
        for (StringBuffer row :
                rows) {
            ans.append(row);
        }
        return ans.toString();
    }
}































