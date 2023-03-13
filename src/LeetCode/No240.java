package LeetCode;



public class No240 {
    /**
     * 在矩阵中寻找target
     * 每一列和每一行均为升序
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix,int target){
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            int[] nums = matrix[i];
            flag = searchLine(nums,target);
            if (flag){
                return true;
            }
        }
        return false;
    }
    public static boolean searchLine(int[] nums,int target){
        int l = 0,r = nums.length - 1;
        while (l <= r){
            int mid = (r-l)/2 + l;
            if (target < nums[mid]){
                r = mid - 1;
            }else if (target > nums[mid]){
                l = mid + 1;
            }
            else return true;
        }
        return false;
    }
}
