package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-time-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No539 {
    public static void main(String[] args) {
        String s = "22:22";
        System.out.println(Integer.parseInt(s.substring(3,5)));
    }
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int pre = getMinutes(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int temp = getMinutes(timePoints.get(i));
            ans = Math.min(ans,temp - pre);
            pre = temp;
        }
        // 首尾时间差
        ans = Math.min(ans,getMinutes(timePoints.get(0)) + 1440 - pre);
        return ans;
    }

    private int getMinutes(String s) {
        return Integer.parseInt(s.substring(0,2))*60 + Integer.parseInt(s.substring(3,5));
    }
}
