package LeetCode;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class No59 {
    public static void main(String[] args) {

    }

    /**
     * 模拟的方法
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        // 设定方向，总是右 下 左 上重复
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curNum = 1;
        int maxNum = n * n;
        int dirIndex = 0;
        int row = 0, column = 0;
        while (curNum <= maxNum) {
            ans[row][column] = curNum;
            curNum++;
            int nextRow = row + dir[dirIndex][0];
            int nextCol = column + dir[dirIndex][1];
            // 如果下一行或下一列超出边界则改变方向
            // 如果下一行列的矩阵不为0，则已经遍历过， 需要改变方向
            if (nextCol >= n || nextCol < 0 || nextRow >= n || nextRow < 0 || ans[nextRow][nextCol] != 0) {
                dirIndex = (dirIndex + 1) % 4;
            }
            row += dir[dirIndex][0];
            column += dir[dirIndex][1];
        }
        return ans;
    }

}
