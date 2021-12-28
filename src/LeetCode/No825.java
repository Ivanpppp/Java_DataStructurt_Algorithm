package LeetCode;

import java.util.Arrays;

/**
 *
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * 示例 2：
 *
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * 示例 3：
 *
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No825 {
    public static void main(String[] args) {
        int[] ages = new int[]{20,30,100,110,120};
        System.out.println(numFriendRequests(ages));
    }

    /**
     * 暴力法超时
     * @param ages
     * @return
     */
    public static int numFriendRequests(int[] ages) {
        int n = ages.length;
        int ans = 0;
        Arrays.sort(ages);
        for (int i = 0; i < n; i++) {
            int temp = ages[i];
            for (int j = 0; j < n; j++) {
                if (rule1(temp,ages[j]) && rule2(temp,ages[j]) && rule3(temp,ages[j]) && i != j){
                    System.out.println(i + " 向 " + j + "发送好友申请");
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 排序 + 双指针
     * @param ages
     * @return
     */
    public static int numFriendRequests2(int[] ages) {
        int ans = 0;
        int n = ages.length;
        // 排序
        Arrays.sort(ages);
        int left = 0;
        int right = 0;
        for (int age :
                ages) {
            // 条件3蕴含在条件2里
            // 如果age小于15直接跳过
            if (age < 15) continue;

            // 维护left，左侧只用满足条件一 a2 <= 0.5 * a1 + 7
            while (ages[left] <= 0.5 * age + 7){
                left++;
            }

            // 维护right，右侧只用满足条件二 a2 > a1
            while (right + 1 < n && ages[right + 1] <= age){
                right++;
            }

            ans += right - left;
        }
        return ans;
    }
    public static boolean rule1(int a1,int a2){
        if (a2 <= 0.5 * a1 + 7){
            return false;
        }
        return true;
    }
    public static boolean rule2(int a1,int a2){
        if (a2 > a1){
            return false;
        }
        return true;
    }
    public static boolean rule3(int a1,int a2){
        if (a2 > 100 && a1< 100){
            return false;
        }
        return true;
    }
}
