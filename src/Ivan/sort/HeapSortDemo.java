package Ivan.sort;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        //大顶堆排序
        int arr[] = {7,4,5,9,6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序
    public static void heapSort(int[] arr) {
        int temp = 0;
        //1.将无序序列构建成一个堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);

        }
        int j = 1;
        //2.将堆顶元素和末尾元素交换，将最大元素“沉”到数组末端
        //3.重新调整结构，使其满足堆的定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("第 "+ j +" 次的大根堆：" +Arrays.toString(arr));
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);

            j++;
        }

    }

    //将一个数组调整成一个大顶堆

    /**
     * @param arr    待调整的数组
     * @param i      表示非叶子节点的在数组中的索引
     * @param length 表示对多少个元素进行调整，每次调整都会-1
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];              //取出当前元素的值，保存在临时的变量中
        //1.j = i*2 + 1 ------> j是i节点的左子节点
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                //说明左子节点的值小于右子节点的值
                j++;    //指向右子节点
            }
            if (arr[j] > temp) {
                //子节点大于父节点
                arr[i] = arr[j]; //把较大的值赋给当前节点
                i = j;           //i指向j，循环比较
            } else {
                break;
            }
        }
        //for循环结束后，我们已经把以i为父节点的树的最大值放在了最顶上
        arr[i] = temp;  //将temp值放在调整后的位置

    }
}
