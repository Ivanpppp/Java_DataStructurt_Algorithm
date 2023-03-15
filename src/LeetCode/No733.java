package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出: [[2,2,2],[2,2,0],[2,0,1]]
 * 解析:
 * 在图像的正中间，(坐标(sr,sc)=(1,1)),
 * 在路径上所有符合条件的像素点的颜色都被更改成2。
 * 注意，右下角的像素没有更改为2，
 * 因为它不是在上下左右四个方向上与初始点相连的像素点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No733 {
    public static void main(String[] args) {

    }

    /**
     * 广度优先搜索：迭代
     * 1.获取给定的sr和sc的image的值，作为当前的颜色
     * 2.如果当前颜色和需要改变的颜色newColor一致，则直接返回image
     * 3.把image[sr][sc]变为newColor
     * 4.image[sr][sc]入队
     * 5.遍历队列，往四个方向上查看，是否需要改变其颜色
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int preColor = image[sr][sc];
        if (preColor == newColor) return image;
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int x = poll[0] + dir[i][0];
                int y = poll[1] + dir[i][1];
                if (image[x][y] == preColor && x >= 0 && x < n && y >= 0 && y < m){
                    image[x][y] = newColor;
                    queue.offer(new int[]{x,y});
                }
            }
        }
        return image;
    }

    /**
     * 递归
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if (curColor == newColor) {
            return image;
        }
        dfs(image, sr, sc, curColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int curColor, int newColor) {
        if (image[sr][sc] == curColor) {
            image[sr][sc] = newColor;
            for (int i = 0; i < 4; i++) {
                int x = sr + dx[i], y = sc + dy[i];
                if (x >= 0 && x < image.length && y >= 0 && y < image[0].length && image[x][y] == curColor) {
                    dfs(image, x, y, curColor, newColor);
                }
            }
        }
    }
}
