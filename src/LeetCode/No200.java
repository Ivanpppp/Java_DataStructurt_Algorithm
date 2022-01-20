package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No200 {

    public static void main(String[] args) {

    }

    /**
     * 深度优先搜索
     * 每次浏览到grid[i][j] == ‘1’ 的格子，ans+=1，再将其他与之相连的置为0，即下次再遍历到的时候不用再重复计算了
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 ||grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    /**
     * 广度优先搜索
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1'){
                    ans++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i,j});
                    while (!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int x = poll[0], y = poll[1];
                        if (x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == '1'){
                            grid[x][y] = '0';
                            queue.offer(new int[]{x-1,y});
                            queue.offer(new int[]{x+1,y});
                            queue.offer(new int[]{x,y-1});
                            queue.offer(new int[]{x,y+1});
                        }
                    }
                }
            }
        }
        return ans;
    }

}
