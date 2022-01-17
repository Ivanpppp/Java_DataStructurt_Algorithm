package LeetCode;

import java.util.Arrays;

/*
给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

 

示例 1：

输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]
示例 2：

输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No977 {


    public static void main(String[] args) {

    }
    // 先平方 再排序
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = A[i] * A[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    // 双指针
    public int[] sortedSquares2(int[] A) {
        // 分别用两个指针指向开头和末尾，在平方过程中就排序
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0,pos = n - 1 , j = n - 1; i <= j;) {
            if (A[i] * A[i] >= A[j] * A[j]){
                ans[pos] = A[i] * A[i];
                i++;
            }else {
                ans[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return ans;
    }
}
