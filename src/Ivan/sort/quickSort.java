package Ivan.sort;

public class quickSort {
    public static void main(String[] args) {
        int arr[] = {1, -1, 3, -4, -5, 5, 34, 67, -4, -4, 15, 6};
        quickSort2(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int p = arr[(left+right)/2];        //基准数
        while (l<r){
            //找到左边比p大的值
            while (arr[l]<p){
                l++;
            }
            //找到右边比p小的值
            while (arr[r] > p){
                r--;
            }
            if (l>=r) break;
            //找到了就交换位置
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完后发现arr[l] == p，前移
            if (arr[l] == p){
                r -= 1;
            }
            if (arr[r] == p){
                l += 1;
            }
        }
        //递归左边和右边
        //如果l==r，必须l++,r--，否则栈溢出
        if (l==r){
            l++;
            r--;
        }
        if (left<r) quickSort(arr, left, r);

        if (right>l) quickSort(arr, l, right);
    }

    public static void quickSort2(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int temp = 0;
        int p = arr[(l+r)/2];
        while(l<r){
            while (arr[l]<p){
                l++;
            }
            while(arr[r]>p){
                r--;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == p){
                l++;
            }
            if (arr[r] == p){
                r--;
            }
            if(r==l){
                r--;
                l++;
            }
            quickSort2(arr,left,r);
            quickSort2(arr,l,right);
        }
    }
}
