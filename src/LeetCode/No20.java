package LeetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No20 {
    public static void main(String[] args) {
        String s = "[{}]";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {
        int n = s.length();
        // 如果长度不为偶数，则说明总会多出一个括号，直接返回false即可
        if (n % 2 != 0){
            return false;
        }
        // 用栈去维护
        Deque<Character> stack = new LinkedList<>();
        // 由于括号是成对出现的，用一个键值对来存放
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        // 对字符串进行循环取出数据
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            // 判断是不是右括号
            if (map.containsKey(cur)){
                // 如果栈为空或者当前栈顶元素不能和它进行匹配，就说明出错
                if (stack.isEmpty() || map.get(cur)!=stack.peek()){
                    return false;
                }
                // 如果能匹配，栈顶元素出栈
                stack.pop();
            }else {
                // 不是右括号，入栈
                stack.push(cur);
            }
        }
        // 如果栈为空，则说明能够全部匹配，否则不能全匹配
        return stack.isEmpty();
    }
}
