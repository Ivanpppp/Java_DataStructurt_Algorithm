package Offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No47 {
    /**
     * 动态规划
     * 方程组为 ：
     * 1. 向右走f(i,j) = f(i-1,j) + grid(i,j)
     * 2. 向下走f(i,j) = f(i,j-1) + grid(i,j)
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0){
                    f[i][j] = Math.max(f[i][j],f[i-1][j]);
                }
                if (j > 0){
                    f[i][j] = Math.max(f[i][j],f[i][j-1]);
                }
                f[i][j]+=grid[i][j];
            }
        }
        return f[n-1][m-1];
    }
}
