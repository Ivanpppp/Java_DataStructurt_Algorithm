package LeetCode;
/*
给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。

每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。

返回赢得比赛的整数。

题目数据 保证 游戏存在赢家。


示例 1：

输入：arr = [2,1,3,5,4,6,7], k = 2
输出：5
解释：一起看一下本场游戏每回合的情况：

因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-winner-of-an-array-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1535 {
    public static void main(String[] args) {
        int[] nums = {2,1,3,5,4,6,7};
        int ans = getWinner(nums,2);
        System.out.println(ans);
    }
    public static int getWinner(int[] arr, int k) {
        // 用pre来维护一个最大值
        int pre = Math.max(arr[0],arr[1]);
        // 计数器
        int count = 1;
        if (k == 1){
            return pre;
        }
        // 因为保证有答案，所以只用从arr[2]开始进行比较
        for (int i = 2; i < arr.length; i++) {
            // cur指的是当前需要比较的值
            int cur = arr[i];
            // 如果比pre小的话，计数器加一
            if (pre > cur){
                count++;
                if (count == k){
                    return pre;
                }
            }else {
                // 否则替换当前的最大值，并把计数器置1
                pre = cur;
                count = 1;
            }
        }
        return pre;
    }
}
