package LeetCode;

public class No43 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = sumString(ans, curr.reverse().toString());
        }
        return ans;

    }

    public static String sumString(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0 || add != 0) {
            int c1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int c2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = c1 + c2 + add;
            sb.append(sum % 10);
            add = sum / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("100", "100"));
    }
}
