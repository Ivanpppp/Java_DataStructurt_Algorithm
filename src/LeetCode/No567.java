package LeetCode;

import java.util.Arrays;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion2(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        int[] nums1 = new int[26];
        int[] nums2 = new int[26];
        for (int i = 0; i < n; i++) {
            nums1[s1.charAt(i) - 'a']++;
            nums2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(nums1, nums2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            nums2[s2.charAt(i) - 'a']++;
            nums2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(nums1, nums2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        int[] m1 = new int[26];
        int[] m2 = new int[26];
        int n = s1.length();
        int m = s2.length();
        if (n > m){
            return false;
        }
        for (int i = 0; i < n; i++) {
            m1[s1.charAt(i) - 'a']++;
            m2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(m1, m2)) return true;
        for (int i = n; i < m; i++) {
            m2[s2.charAt(i) - 'a']++;
            m2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(m1, m2)) return true;
        }
        return false;
    }


}
