package LeetCode;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No383 {
    public static void main(String[] args) {

    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] nums1 = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            nums1[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < magazine.length(); i++) {
            nums1[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] < 0) return false;
        }
        return true;
    }
}
