package LeetCode;

/*
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

 



图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

 

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/container-with-most-water
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No11 {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int ans = maxArea(nums);
        System.out.println(ans);
    }
    public static int maxArea(int[] height) {
        // 首先列出height[]的长度
        int n = height.length;
        if (n == 0){
            return 0;
        }
        // 双指针做法
        int left = 0;
        int right = n - 1;
        // 用于维护最大值
        int max = 0;
        // 开始循环，退出循环条件——left == right
        while (left != right){
            // 用cur来表示当前的容积，体积是：短的那条边*(right-left)
            int cur = Math.min(height[left],height[right]) * (right - left);
            // 维护max
            max = Math.max(max,cur);
            // 比较height[left]和height[right]，哪条边短，就让短的那条边进行移动
            if (height[left] > height[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }
}
