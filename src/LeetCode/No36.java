package LeetCode;

import java.util.*;

/**
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *  
 *
 * 注意：
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No36 {
    public static void main(String[] args) {

    }
    public boolean isValidSudoku(char[][] board){
        // 一次遍历
        Map<Integer,Integer>[] rows = new HashMap[9];
        Map<Integer,Integer>[] cols = new HashMap[9];
        Map<Integer,Integer>[] mats = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            mats[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char temp = board[i][j];
                if (temp == '.'){
                    continue;
                }
                int num = (int) temp;
                rows[i].put(num,rows[i].getOrDefault(num,0) + 1);
                cols[j].put(num,cols[j].getOrDefault(num,0) + 1);
                int box_num = (i / 3) * 3 + j / 3;
                mats[box_num].put(num,mats[box_num].getOrDefault(num,0) + 1);
                if (mats[box_num].get(num) > 1 || rows[i].get(num) > 1 || cols[j].get(num) > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
