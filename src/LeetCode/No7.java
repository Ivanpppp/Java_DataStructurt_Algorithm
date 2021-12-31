package LeetCode;

/**
 * 整数反转
 */
public class No7 {
    public static void main(String[] args) {

    }
    public int reverse(int num){
        int ans = 0;
        while (num != 0){
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10){
                return 0;
            }
            int digit = num % 10;
            ans = ans * 10 + digit;
            num /= 10;
        }
        return ans;
    }
}
