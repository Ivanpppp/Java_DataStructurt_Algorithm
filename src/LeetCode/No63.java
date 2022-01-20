package LeetCode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No63 {
    public static void main(String[] args) {

    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
                f[i][0] = 1;
        }
        for (int i = 0; i < m && obstacleGrid[0][i] == 0; i++) {
                f[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0){
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[n-1][m-1];

    }
}
