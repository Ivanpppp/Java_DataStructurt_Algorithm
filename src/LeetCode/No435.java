package LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class No435 {
    /**
     * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
     * 示例 1:
     * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * 输出: 1
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     * 输入: intervals = [ [1,2], [1,2], [1,2] ]
     * 输出: 2
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     * 输入: intervals = [ [1,2], [2,3] ]
     * 输出: 0
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/non-overlapping-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0){
            return 0;
        }
        // 按照左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = intervals.length;
        int[] f = new int[n];
        // 初始化数组
        Arrays.fill(f,1);
        for (int i = 1; i < intervals.length; i++) {
            System.out.println("当前为第"+i+"次循环-----------------------");
            for (int j = 0; j < i; j++) {
                System.out.println("当前"+i+"数组的值为"+intervals[i][0]+" "+intervals[i][1]);
                System.out.println("当前"+j+"数组的值为"+intervals[j][0]+" "+intervals[j][1]);
                if (intervals[j][1] <= intervals[i][0]){
                    System.out.println("满足条件，维护f[i]---------------------------------");
                    System.out.println("当前的f[i]值为"+f[i]);
                    f[i] = Math.max(f[i],f[j]+1);
                    System.out.println("修改当前f[i]的值为"+f[i]);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,4},{1,3},{4,5}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
