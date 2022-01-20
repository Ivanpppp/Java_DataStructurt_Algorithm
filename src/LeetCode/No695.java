package LeetCode;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No695 {
    public static void main(String[] args) {

    }

    /**
     * 深度优先搜索
     * 遍历矩阵
     * 每当当前格子是1的时候，对四个方向进行递归，四个方向递归的值相加就是该岛屿的面积了
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        if (grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    int cur = dfs(grid,i,j);
                    ans = Math.max(ans,cur);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(grid,i+1,j);
        num += dfs(grid,i-1,j);
        num += dfs(grid,i,j+1);
        num += dfs(grid,i,j-1);
        return num;
    }
}
