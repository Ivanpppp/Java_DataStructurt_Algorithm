package Ivan.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        int ans = test(5);
        System.out.println(ans);

    }

    //    public static void test(int n,int temp){
//        if (n<=0){
//            return;
//        }
//
//        temp*=n;
//        if (n>1){
//            System.out.printf("%d*",n);
//        }else {
//            System.out.printf("%d=%d",n,temp);
//        }
//        test(n-1,temp);
//    }
    public static int test(int n) {
        if (n == 1) {
            return 1;
        }else if (n>0){
            int ans = test(n - 1) * n;
            return ans;
        }else {
            return 1;
        }
    }
}
