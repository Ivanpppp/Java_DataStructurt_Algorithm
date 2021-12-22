package LeetCode;

/**
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 * 示例 2：
 *
 * 输入：date = "2019-02-10"
 * 输出：41
 * 示例 3：
 *
 * 输入：date = "2003-03-01"
 * 输出：60
 * 示例 4：
 *
 * 输入：date = "2004-03-01"
 * 输出：61
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No1154 {

    public static void main(String[] args) {
        String date = "2021-01-01";
        System.out.println(dayOfYear(date));

    }

    public static int dayOfYear(String date) {
        String[] list = date.split("-");
        int ans = 0;
        int amount[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int year = Integer.parseInt(list[0]);
        int month = Integer.parseInt(list[1]);
        int day = Integer.parseInt(list[2]);
        // 判断是否是闰年
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            amount[1]++;
        }
        for (int i = 0; i < month - 1; i++) {
            ans += amount[i];
        }
        return  ans + day;
    }
}
