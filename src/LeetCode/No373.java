package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 *
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 *
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No373 {
    public static void main(String[] args) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        List<List<Integer>> list = kSmallestPairs(nums1, nums2, 3);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.printf(list.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 优先队列/堆
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k,(o1,o2)->{
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        for (int i = 0; i < Math.min(n, k); i++) {
            priorityQueue.offer(new int[]{i,0});
        }
        while (k-- > 0 && !priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[poll[0]]);
            list.add(nums2[poll[1]]);
            ans.add(list);
            if (poll[1] + 1 < m) {
                priorityQueue.offer(new int[]{poll[0],poll[1] + 1});
            }
        }
        return ans;
    }
}
