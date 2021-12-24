package LeetCode;

import java.util.PriorityQueue;

/**
 *
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 *
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 *
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * 示例 2：
 *
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class No1705 {
    public static void main(String[] args) {

    }

    public static int eatenApples(int[] apples, int[] days) {
        // 优先队列 + 贪心算法
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int ans = 0,i = 0;
        int n = apples.length;
        while (i < n){
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= i){
                // 如果剩下天数的值比i小了，则抛出，苹果全部腐烂了
                priorityQueue.poll();
            }
            int restDay = i + days[i];
            int count = apples[i];
            if (count > 0){
                // 如果当天生产的苹果>0，入队
                priorityQueue.offer(new int[]{restDay,count});
            }
            // 维护最开始的优先队列中的苹果值
            if (!priorityQueue.isEmpty()){
                int temp = priorityQueue.peek()[1];
                temp--;
                if (temp == 0){
                    // 如果消耗了苹果，没有剩余了，就把这个数组出队即可
                    priorityQueue.poll();
                }
                ans++;
            }
            i++;
        }
        // 存在最后几天还剩很多苹果的情况
        while (!priorityQueue.isEmpty()){
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= i){
                priorityQueue.poll();
            }
            if (priorityQueue.isEmpty()) break;
            ans += Math.min(priorityQueue.peek()[0] - i,priorityQueue.peek()[1]);
            i += Math.min(priorityQueue.peek()[0] - i,priorityQueue.peek()[1]);
            priorityQueue.poll();
        }
        return ans;

//        int ans = 0;
//        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
//        int n = apples.length;
//        int i = 0;
//        while (i < n) {
//            while (!pq.isEmpty() && pq.peek()[0] <= i) {
//                pq.poll();
//            }
//            int rottenDay = i + days[i];
//            int count = apples[i];
//            if (count > 0) {
//                pq.offer(new int[]{rottenDay, count});
//            }
//            if (!pq.isEmpty()) {
//                int[] arr = pq.peek();
//                arr[1]--;
//                if (arr[1] == 0) {
//                    pq.poll();
//                }
//                ans++;
//            }
//            i++;
//        }
//        while (!pq.isEmpty()) {
//            while (!pq.isEmpty() && pq.peek()[0] <= i) {
//                pq.poll();
//            }
//            if (pq.isEmpty()) {
//                break;
//            }
//            int[] arr = pq.poll();
//            int curr = Math.min(arr[0] - i, arr[1]);
//            ans += curr;
//            i += curr;
//        }
//        return ans;
    }
}
