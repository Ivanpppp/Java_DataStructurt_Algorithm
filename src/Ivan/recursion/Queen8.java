package Ivan.recursion;

public class Queen8 {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //数组arr存放皇后放置位置
    int[] arr = new int[max];

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
    }


    //放置第n个皇后

    public void check(int n) {
        if (n == max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //先把当前的皇后n，放到该行的第一列
            arr[n] = i;
            if (judge(n)){
                //不冲突则继续放
                check(n+1);
            }
            //冲突则继续执行arr[n] = i；即第n个皇后放在本行的后移的一个位置
        }
    }

    private void print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
    }

    //判断当前位置是否冲突

    /**
     * @param n 表示第n个皇后
     * @return 表示位置是否合理
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //arr[i] == arr[n]表示第n个皇后和第i个皇后是否在同一列
            //Math.abs(n-i) == Math.abs(arr[n]-arr[i])表示第n个皇后和第i个皇后是否在同一斜线  斜率
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
