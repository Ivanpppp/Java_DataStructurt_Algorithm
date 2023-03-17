package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No994 {
    public static void main(String[] args) {

    }

    /**
     * 广度优先遍历
     * 每次都会让周围的橘子坏掉，满足广度优先遍历的情况
     * 如果最后还有橘子没有腐烂，则返回-1
     * 说明需要用一个count来表示所有的橘子数
     * 如果最后count ！= 0 说明还有橘子没有腐烂
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        while (count > 0 && !queue.isEmpty()) {
            int s = queue.size();
            for (int j = 0; j < s; j++) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (mx < n && my < m && mx >= 0 && my >= 0 && grid[mx][my] == 1) {
                        grid[mx][my] = 2;
                        count--;
                        queue.offer(new int[]{mx, my});
                    }
                }
            }
            ans++;
        }
        return count > 0 ? -1 : ans;
    }

    public int orangesRotting2(int[][] grid) {
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        if (grid == null || grid.length == 0) return -1;
        int ans = 0;
        int count = 0;
        int n = grid.length, m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        while (count > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int x = poll[0], y = poll[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        count--;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
            ans++;
        }


        return count > 0 ? -1 : ans;
    }
}
