package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No75 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,4};
        sortColors(nums);
        for (int n :
                nums) {
            System.out.printf(n+" ");
        }
    }

    /**
     * 1. 如不使用sort函数，可以进行冒泡排序
     * 2. 可使用map进行一次遍历，然后改变其值
     * 3. 使用双指针，原地对nums进行修改
     *  指针p1和1交换
     *  指针p0和0交换
     * @param nums
     */
    public static void sortColors(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(((o1, o2) -> o1 - o2));
        for (int n :
                nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int index = 0;
        for (int n :
                map.keySet()) {
            for (int i = 0; i < map.get(n); i++) {
                nums[index] = n;
                index++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = 0,p1 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 和p1交换
            if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
            // 和p0交换
           else if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p1++;
                p0++;
            }

        }
    }
}
