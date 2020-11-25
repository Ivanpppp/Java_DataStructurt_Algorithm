package LeetCode;

/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

 

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divide-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No29 {
    public static void main(String[] args) {
        int dividend = -7;
        int divisor = -1;
        System.out.println(divide(dividend,divisor));
    }
    public static int divide(int dividend, int divisor) {
        if (Math.abs(divisor) == 1){
            return divisor > 0 ? dividend : -dividend;
        }
        // 直接递归实现
        // 如果两个数都为正数
        if (dividend > 0 && divisor > 0){
            if (dividend < divisor){return 0;}
            dividend -= divisor;
            return divide(dividend,divisor)+1;
        }else if (dividend < 0 && divisor < 0){
            dividend = -dividend;
            divisor = -divisor;
            if (dividend < divisor){return 0;}
            dividend -= divisor;
            return divide(dividend,divisor)+1;
        }else{
            dividend =Math.abs(dividend);

            divisor =Math.abs(divisor);
            if (dividend < divisor){return 0;}
            dividend -= divisor;
            int ans = divide(dividend,divisor) + 1;
            return ans*-1;
        }

    }
}
