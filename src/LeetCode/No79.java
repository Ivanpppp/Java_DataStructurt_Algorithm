package LeetCode;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No79 {
    public static void main(String[] args) {

    }
    public static boolean Solution(char[][] board,String word){
        // 使用DFS来对题目进行求解
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(board,vis,i,j,0,word);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param board char[][]矩阵
     * @param vis   用于判断是否走过此元素
     * @param x     新的一个x坐标
     * @param y     新的一个y坐标
     * @param k     Word中第k个元素
     * @param word  需要查找的字符串
     */
    public static boolean dfs(char[][] board,boolean[][] vis,int x,int y, int k,String word){
        // 递归退出条件
        if (board[x][y] != word.charAt(k)){
            return false;
        }else if (k == word.length() - 1){
            return true;
        }
        // 表明当前该元素被走过
        vis[x][y] = true;
        // 搜索方向
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        // 结果
        boolean result = false;
        for (int[] dic :
                directions) {
            // 边界判断
            int newX = x + dic[0];
            int newY = y + dic[1];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length){
                if (!vis[newX][newY]){
                    boolean flag = dfs(board,vis,newX,newY,k+1,word);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        // 回溯，所以将vis[x][y]重置为false
        vis[x][y] = false;
        return result;
    }
}
