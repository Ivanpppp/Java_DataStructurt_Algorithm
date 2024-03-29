package MeiTuan2021Autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。已知货物入库的时候是按顺序堆放在一起的。如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，这样可以保证货物局部的顺序不变。
 * 已知货物最初是按 1~n 的顺序堆放的，每件货物的重量为 w[i] ,小美会根据单据依次不放回的取出货物。请问根据上述操作，小美每取出一件货物之后，重量和最大的一堆货物重量是多少？
 *
 * 格式：
 *
 *
 * 输入：
 * - 输入第一行包含一个正整数 n ，表示货物的数量。
 * - 输入第二行包含 n 个正整数，表示 1~n 号货物的重量 w[i] 。
 * - 输入第三行有 n 个数，表示小美按顺序取出的货物的编号，也就是一个 1~n 的全排列。
 * 输出：
 * - 输出包含 n 行，每行一个整数，表示每取出一件货物以后，对于重量和最大的一堆货物，其重量和为多少。
 * 示例：
 *
 *
 * 输入：
 *      5
 *      3 2 4 4 5
 *      4 3 5 2 1
 * 输出：
 *      9
 *      5
 *      5
 *      3
 *      0
 * 解释：
 * 原本的状态是 {{3,2,4,4,5}} ，取出 4 号货物后，得到 {{3,2,4},{5}} ，第一堆货物的和是 9 ，然后取出 3 号货物得到 {{3,2}{5}} ，此时第一堆和第二堆的和都是 5 ，以此类推。
 * 提示：
 *
 * 1 <= n <= 50000
 * 1 <= w[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/TJZLyC
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class test02 {
    public static void main(String[] args) {
        // 初始化数组
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        // nums2代表取快递的顺序
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int cur = nums2[i];
            int left = 0;
            int right = 0;
            for (int j = 0; j < cur - 1; j++) {
                left += list.get(j);
            }
            for (int j = list.size() - 1; j > cur - 1; j--) {
                right += list.get(j);
            }
            // 维护nums1的值
            list.remove(cur - 1);
            System.out.println(Math.max(left,right) + "     list.size : " + list.size());
        }
    }
}
