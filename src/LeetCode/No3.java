package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No3 {
    public static void main(String[] args) {
        String s = "aaaaaa";
        int n = lengthOfLongestSubstring(s);
        System.out.println(n);
    }

    public static int lengthOfLongestSubstring(String s) {
        // 用一个HashSet来存储当前的字符
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        int r = 0;          //右边的指针
        int ans = 0;        //结果
        for (int i = 0; i < n; i++) {
            if (i!=0){
                set.remove(s.charAt(i-1));
            }
            while (r < n && set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;
            }
            ans = Math.max(ans,r-i);
        }
        return ans;
    }
}
