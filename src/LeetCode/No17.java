package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No17 {
    public static void main(String[] args) {

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
        Map<Character,String> map = new HashMap<Character,String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(ans,map,digits,0,new StringBuffer());
        return ans;
    }

    private void backtrack(List<String> ans, Map<Character, String> map, String digits, int i, StringBuffer stringBuffer) {
        if (i == digits.length()) {
            ans.add(stringBuffer.toString());
        }else {
            char digit = digits.charAt(i);
            String letters = map.get(digit);
            for (int j = 0; j < letters.length(); j++) {
                stringBuffer.append(letters.charAt(j));
                backtrack(ans,map,digits,i+1,stringBuffer);
                stringBuffer.deleteCharAt(i);
            }
        }
    }
}
