package LeetCode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * <p>
 * 两个相邻元素间的距离为 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No542 {
    public static void main(String[] args) {

    }

    /**
     * 广度优先算法
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        boolean[][] seen = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && my >= 0 && mx < n && my < m && !seen[mx][my]) {
                    ans[mx][my] = ans[x][y] + 1;
                    seen[mx][my] = true;
                    queue.offer(new int[]{mx, my});
                }
            }
        }
        return ans;
    }

    public int[][] updateMatrix2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    seen[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < n && nx >= 0 && ny < m && ny >= 0 && !seen[nx][ny]) {
                    ans[nx][ny] = ans[x][y] + 1;
                    seen[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return ans;
    }
}
