package Ivan.sort;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {1, -1, 3, -4, -5, 5, 34, 67, -4, -4, 15, 6};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * @param arr   需要排序的数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  作为中转的数组
     */
    public static void mergeSort(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;       //初始化i，左边有序序列的初始索引
        int j = mid + 1;    //初始化j，右边有序序列的初始索引
        int t = 0;          //指向temp的当前索引

        //先把左右两边的数据按照规则填充到temp
        while (i<=mid && j<=right){
            //如果左边有序序列小于当前元素，把左边的当前元素填充到temp数组
            if (arr[i] < arr[j]){
                temp[t] = arr[i];
                t+=1;
                j+=1;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t] = arr[j];
            t++;
            j++;
        }
    }
}
