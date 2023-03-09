package nowcoder.huawei;

import java.util.Scanner;

/**
    输入包括多组测试数据。
每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
学生ID编号从1编到N。
第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。

输出描述:
对于每一次询问操作，在一行里面输出最高成绩.

输入例子1:
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

输出例子1:
5
6
5
9
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars1 = scanner.nextLine().replaceAll(" ", "").toCharArray();
        int n = Character.getNumericValue(chars1[0]);
        int m = Character.getNumericValue(chars1[1]);
        System.out.println(n+" "+m);
        int[] grades = new int[n];
        String s = scanner.nextLine();
        char[] cs = s.replaceAll(" ", "").toCharArray();
        for (int i = 0; i < n; i++) {
            grades[i] = Character.getNumericValue(cs[i]);
            System.out.println(grades[i]);
        }
        for (int i = 0; i < m; i++) {
            String temp = scanner.nextLine();
            temp = temp.replaceAll(" ","");
            char[] chars = temp.toCharArray();
            if (chars[0] == 'U'){
                update(grades,Character.getNumericValue(chars[1]),Character.getNumericValue(chars[2]));
            }else if (chars[0] == 'Q'){
                query(grades,Character.getNumericValue(chars[1]),Character.getNumericValue(chars[2]));
            }
        }
    }

    public static void update(int[]grades,int num,int grade){
        grades[num - 1] = grade;
    }
    public static void query(int[] grades,int s,int e){
        int max = Integer.MIN_VALUE;
        for (int i = s - 1; i <= e - 1; i++) {
            max = Math.max(grades[i],max);
        }
        System.out.println(max);
    }

}
