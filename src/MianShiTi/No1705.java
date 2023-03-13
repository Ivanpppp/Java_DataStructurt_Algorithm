package MianShiTi;

import java.util.HashMap;

public class No1705 {

    /**
     * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
     * <p>
     * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
     * <p>
     * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
     * 示例 2:
     * <p>
     * 输入: ["A","A"]
     * <p>
     * 输出: []
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-longest-subarray-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String[] findLongestSubarray(String[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// 初始化map
        int sum = 0;// 记录数组的字母与数字个数
        int maxLen = 0;
        int startIndex = -1;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                int firIndex = map.get(sum);
                if (i - firIndex > maxLen) {
                    maxLen = i - firIndex;
                    startIndex = firIndex + 1;
                }
            }else {
                map.put(sum,i);
            }
        }
        if (maxLen == 0){
            return new String[]{};
        }
        String[] ans = new String[maxLen];
        System.arraycopy(array,startIndex,ans,0,maxLen);
        return ans;
    }
}
