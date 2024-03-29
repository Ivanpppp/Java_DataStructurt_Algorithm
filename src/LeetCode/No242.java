package LeetCode;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No242 {
    public static void main(String[] args) {
        String a = "abc";
        String b = "ddd";
        System.out.println(isAnagram(a,b));
    }
    public static boolean isAnagram(String s, String t) {
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            t1[t.charAt(i) - 'a']++;
        }
        if (Arrays.equals(s1,t1)) return true;
        return false;
    }
}
