package VivoTest;

/*
    回文字符串 —— 最多删除一个字符，如果还是回文串也可
 */
public class test2 {
    public static void main(String[] args) {
        String a = "abcd";
        isHuiWenChuan(a);
    }

    public static boolean isHuiWenChuan(String a){
        // n为a的长度
        int n = a.length();
        // 从头到尾遍历，如果有一个不同则跳过，flag+1，如果flag > 1，则返回false
        int flag = 0;
        for (int i = 0; i < n/2; i++) {
            char c1 = a.charAt(i);
            char c2 = a.charAt(n-i-1);
            if (c2 == c1){
                continue;
            }else {
//                c2 =
            }

        }
        return false;
    }
}
