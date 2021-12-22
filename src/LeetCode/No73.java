package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 */
public class No73 {
    public static void main(String[] args) {
        int[][] mat = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
            List<Integer> rows = new ArrayList<>();
            List<Integer> cols = new ArrayList<>();
            int n = matrix.length;
            int m = matrix[0].length;
            // 找到初始零的位置
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0){
                        cols.add(j);
                        rows.add(i);
                    }
                }
            }
            // 遍历rows，把横向的变为0
            for (int i = 0; i < rows.size(); i++) {
                int row = rows.get(i);
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[row][j] = 0;
                }
            }
            // 遍历cols，把竖向的变为0
            for (int i = 0; i < cols.size(); i++) {
                int col = cols.get(i);
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][col] = 0;
                }
            }
    }
}
