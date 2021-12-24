package MeiTuan2021Autumn;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(scanner.next());
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (isCorrect(list.get(i))){
                ans.add("Accept");
            }else {
                ans.add("Wrong");
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static boolean isCorrect(String s){
        // 如果首位不是字母返回false
        if (!Character.isLetter(s.charAt(0))) {
            return false;
        }
        // 判断是否包含数字
        boolean flag = false;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果不是字母/数字，返回false
            if (!Character.isDigit(c) && !Character.isLetter(c)){
                return false;
            }
            if (Character.isDigit(c)) flag = true;
        }
        return flag;
    }
}
