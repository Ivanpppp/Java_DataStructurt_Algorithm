package Ivan;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int count = 0;
        if (n > Integer.MAX_VALUE || n < Integer.MIN_VALUE){
            System.out.println(0);
            return;
        }
        StringBuffer s = new StringBuffer();
        while (n!=0){
            s.append(n%2);
            if (n%2 == 1){
                count++;
            }
            n = n/2;
        }
        System.out.println(count);
    }
}

