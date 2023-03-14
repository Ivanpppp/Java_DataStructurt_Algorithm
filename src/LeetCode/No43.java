package LeetCode;

public class No43 {
    public String multiply(String num1, String num2) {
        if (num2.equals("0") || num1.equals("0")) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num1.length(); i++) {
            int cur = num1.charAt(i) - '0';
            StringBuffer curStr = new StringBuffer();
            for (int j = 0; j < num2.length(); j++) {
                int curNum2 = num2.charAt(j) - '0';
                int sum = curNum2 * cur;
                
            }
        }
    }

    public static String sumString(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1;
        int add = 0;
        while (i >= 0 || j >= 0) {
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
        System.out.println(sumString("123", "123"));
    }
}
