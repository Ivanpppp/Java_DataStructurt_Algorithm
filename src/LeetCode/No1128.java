package LeetCode;

/*
给你一个由一些多米诺骨牌组成的列表 dominoes。

如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。

形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。

在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。

 

示例：

输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1128 {
    public static void main(String[] args) {

    }

    public int numEquivDominoPairs(int[][] dominoes) {
        //因为每个数字都不超过9，直接把一对数字用一个两位数来表式，规定小的数为十位
        int[] num = new int[100];
        int ret = 0;
        for (int[] demino:
             dominoes) {
            // 用val表示这个二位数
            int val = demino[0] < demino[1] ? demino[0]*10 + demino[1] : demino[1] * 10 + demino[0];
            // 如果num[val]不为0，ret = ret + num[val]
            ret += num[val];
            num[val]++;
        }
        return ret;
    }
}
