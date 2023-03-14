package LeetCode;

import java.util.Map;

public class No1605 {
    public static void main(String[] args) {

    }

    /**
     * 给你两个非负整数数组rowSum 和colSum，其中rowSum[i]是二维矩阵中第 i行元素的和， colSum[j]是第 j列元素的和。
     * 换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
     * 请找到大小为rowSum.length x colSum.length的任意 非负整数矩阵，且该矩阵满足rowSum 和colSum的要求。
     * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个可行矩阵。
     * <p>
     * 示例 1：
     * 输入：rowSum = [3,8], colSum = [4,7]
     * 输出：[[3,0],
     * [1,7]]
     * 解释：
     * 第 0 行：3 + 0 = 3 == rowSum[0]
     * 第 1 行：1 + 7 = 8 == rowSum[1]
     * 第 0 列：3 + 1 = 4 == colSum[0]
     * 第 1 列：0 + 7 = 7 == colSum[1]
     * 行和列的和都满足题目要求，且所有矩阵元素都是非负的。
     * 另一个可行的矩阵为：[[1,2],
     * [3,5]]
     * 示例 2：
     * 输入：rowSum = [5,7,10], colSum = [8,6,8]
     * 输出：[[0,5,0],
     * [6,1,0],
     * [2,0,8]]
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}
