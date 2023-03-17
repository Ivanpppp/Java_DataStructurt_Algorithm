package LeetCode;

public class No50 {
    /**
     * 实现pow(x, n)，即计算 x 的整数n 次幂函数（即，xn ）。·
     * 示例 1：
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     *
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        // 递归
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    public double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public double quickMul2(double x, int n) {
        double ans = 1.0;
        double x_c = x;
        long N = n;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= x_c;
            }
            x_c *= x_c;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
