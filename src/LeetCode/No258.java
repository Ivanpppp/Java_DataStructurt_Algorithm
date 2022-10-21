package LeetCode;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 */
public class No258 {
    public static void main(String[] args) {

    }

    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
     * @param num
     * @return
     */
    public int addDigits(int num) {
        while (num >= 10){
            int ans = 0;
            while (num > 0) {
                ans += num % 10;
                num/=10;
            }
            num = ans;
        }
        return num;
    }
}
