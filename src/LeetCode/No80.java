package LeetCode;
/*
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。


给定 nums = [1,1,1,2,2,3],

函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

你不需要考虑数组中超出新长度后面的元素。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No80 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,2,2,3,3};
        int ans = removeDuplicates(nums);
        System.out.println(ans);

    }
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] == nums[i]){
                count++;
            }else {
                count = 1;
            }
            if (count<=2){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
