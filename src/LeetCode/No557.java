package LeetCode;
/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。


示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

 */
public class No557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        s = reverseWords(s);
        System.out.println(s);
    }
    public static String reverseWords(String s) {
        int n = s.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
            int start = i;
            while (i<n && s.charAt(i)!=' '){
                i++;
            }
            for (int j = i - 1; j >= start ; j--) {
                stringBuffer.append(s.charAt(j));
            }
            stringBuffer.append(" ");
        }
        stringBuffer.deleteCharAt(n);
        return stringBuffer.toString();
    }
}

