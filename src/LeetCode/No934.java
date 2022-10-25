package LeetCode;

import Ivan.recursion.Queen8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个大小为 n x n 的二元矩阵 grid ，其中 1 表示陆地，0 表示水域。
 *
 * 岛 是由四面相连的 1 形成的一个最大组，即不会与非组内的任何其他 1 相连。grid 中 恰好存在两座岛 。
 *
 * 你可以将任意数量的 0 变为 1 ，以使两座岛连接起来，变成 一座岛 。
 *
 * 返回必须翻转的 0 的最小数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 *
 * 输入：grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shortest-bridge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No934 {
    /**
     * 1. BFS
     * 2. 深度优先搜索，先把grid里为1的存入数据集中，把已知的1置为-1
     * 3. 队列进行遍历，如果队列遍历完，则无需翻转，如果没有遍历完，就是遍历的次数
     * @param grid
     * @return
     */
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int dx = poll[0];
                        int dy = poll[1];
                        list.add(poll);
                        for (int k = 0; k < 4; k++) {
                            int nx = dx + dirs[k][0];
                            int ny = dy + dirs[k][1];
                            if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 1) {
                                queue.offer(new int[]{nx, ny});
                                grid[nx][ny] = -1;
                            }
                        }
                    }
                    for (int[] e :
                            list) {
                        queue.offer(e);
                    }
                    int steps = 0;
                    while (!queue.isEmpty()){
                        int sz = queue.size();
                        for (int k = 0; k < sz; k++) {
                            int[] poll = queue.poll();
                            int dx = poll[0];
                            int dy = poll[1];
                            for (int m = 0; m < 4; m++) {
                                int nx = dx + dirs[m][0];
                                int ny = dy + dirs[m][1];
                                if (nx >= 0 && ny >= 0 && nx < n && ny < n){
                                    if (grid[nx][ny] == 0){
                                        queue.offer(new int[]{nx,ny});
                                        grid[nx][ny] = -1;
                                    }
                                    else if (grid[nx][ny] == 1){
                                        return steps;
                                    }
                                }
                            }
                        }
                        steps++;
                    }
                }
            }
        }
        return 0;
    }
}
