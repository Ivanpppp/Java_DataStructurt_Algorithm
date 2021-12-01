package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 

提示:

1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("aabbaa", "ab"));
    }


    public static List<Integer> findAnagrams(String s, String p) {
        // 特例判断
        if (s.length() < p.length()){
            return new ArrayList<>();
        }

        // 取两个字符串的长度
        int slen = s.length();
        int plen = p.length();

        // 计算每个字符串的取值
        List<Integer> list = new ArrayList<>();
        // 计算词频
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        // 初始化
        for (int i = 0; i < plen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // 如果sCount和pCount相同，则返回第一个
        if (Arrays.equals(sCount,pCount)) list.add(0);

        //
        for (int i = 0; i < slen - plen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + plen) - 'a']++;

            // 如果数组相同则返回i
            if (Arrays.equals(sCount,pCount)) list.add(i+1);
        }
        return list;


    }
}
