package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。

运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：

名次第 1 的运动员获金牌 "Gold Medal" 。
名次第 2 的运动员获银牌 "Silver Medal" 。
名次第 3 的运动员获铜牌 "Bronze Medal" 。
从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。

 

示例 1：

输入：score = [5,4,3,2,1]
输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
示例 2：

输入：score = [10,3,8,9,4]
输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 

提示：

n == score.length
1 <= n <= 104
0 <= score[i] <= 106
score 中的所有值 互不相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/relative-ranks
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No506 {
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        System.out.println(findRelativeRanks(test));
    }

    public static String[] findRelativeRanks(int[] score) {
        String[] top3 = new String[]{"Gold Medal","Silver Medal","Bronze Medal"};
        int len = score.length;
        int[] score1 = score.clone();
        Arrays.sort(score1);
        // 用Map来保存名次
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = len-1; i  >= 0 ; i--) {
            map.put(score1[i],len - i - 1);
        }
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            int rank = map.get(score[i]);
            ans[i] = rank < 3 ? top3[rank] : String.valueOf(rank + 1);
        }
        return ans;
    }
}
