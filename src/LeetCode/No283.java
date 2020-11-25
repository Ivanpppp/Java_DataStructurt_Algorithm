package LeetCode;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No283 {
    public static void main(String[] args) {

        int[] nums = {1,2,1,0,1,1};
        moveZeroes(nums);
        for (int n :
                nums) {
            System.out.print(n);
        }
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        // 双指针
        int left = 0;
        int right = 0;
        // 左指针用于维护当前最后一个不为0的位置
        while (right < n){
            // 如果当右指针不为零的时候，进行交换
            if (nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left += 1;
            }
            right += 1;
        }
    }
}
