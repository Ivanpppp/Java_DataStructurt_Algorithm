package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] intersect = intersect(nums1, nums2);
        for (int num :
                intersect) {
            System.out.println(num);
        }
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        List<Integer> list = new LinkedList<>();
        int p1 = 0,p2 =0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (p1 < n && p2 < m ){
            int t1 = nums1[p1];
            int t2 = nums2[p2];
            if (t1 < t2){
                p1++;
            }else if (t1 > t2){
                p2++;
            }else {
                list.add(t1);
                p1++;
                p2++;
            }

        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
