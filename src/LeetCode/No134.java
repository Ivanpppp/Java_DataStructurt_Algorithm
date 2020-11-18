package LeetCode;

/*
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。

你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。

如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 

如果题目有解，该答案即为唯一答案。
输入数组均为非空数组，且长度相同。
输入数组中的元素均为非负数。
示例 1:

输入:
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/gas-station
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No134 {
    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 一次遍历，判断从每个站点出发是否能环路一周行驶
        int n = gas.length;
        int i = 0; //第i个站点
        while (i < n){
            int sumOfCost = 0; //用于存储所消耗的汽油
            int sumOfGas = 0; //用于存储所拥有的汽油
            int cnt = 0; //计数，判断是否能绕一周
            while (cnt < n){
                int j = (cnt + i) % n; //如果不是从0出发，会出现溢出的情况，用取余来获得当前站点
                sumOfCost += cost[j];
                sumOfGas += gas[j];
                if (sumOfCost > sumOfGas) break;
                cnt++;
            }
            if (cnt == n){
                return i;
            }else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }
}
