package LeetCode;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No56 {
    public static void main(String[] args) {
        int[][] ints = {{1,3},{2,6},{8,10},{15,17},{16,20}};
        System.out.println();


    }
    public int[][] merge(int[][] intervals) {
       if (intervals.length == 0){
           return new int[0][2];
       }
       Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[0] - o2[0];
           }
       });
       List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < left) {
                list.add(new int[]{left,right});
            }else {
                list.get(list.size()- 1)[1] = Math.max(list.get(list.size()-1)[1],right);
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
