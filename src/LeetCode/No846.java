package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 *
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No846 {
    public static void main(String[] args) {

    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);
        Map<Integer,Integer> map = new HashMap<>();
        for (int e :
                hand) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        for (int e :
                hand) {
            if (!map.containsKey(e)) continue;
            for (int i = 0; i < groupSize; i++) {
                int num = e + i;
                if (!map.containsKey(num)) return false;
                map.put(num,map.get(num) - 1);
                if (map.get(num) == 0) map.remove(num);
            }
        }
        return true;
    }
}
