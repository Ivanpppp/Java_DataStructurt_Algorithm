package Ivan.sort;

public class ShellSort {
    public static void main(String[] args) {
        int arr[] = {1, -1, 3, -4, -5, 5, 34, 67, -4, -4, 15, 6, -523};
        Shell2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //交换式
    public static void Shell(int arr[]) {
        int temp = 0;
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }
    }

    //移动式
    public static void Shell2(int arr[]) {
        for (int i = arr.length / 2; i > 0; i /= 2) {      //i为步长
            for (int j = i; j < arr.length; j++) {
                int k = j;
                int temp = arr[j];
                if (arr[j] < arr[j - i]) {
                    while (k - i >= 0 && temp < arr[k - i]) {
                        arr[k] = arr[k - i];
                        k -= i;
                    }
                    arr[k] = temp;
                }
            }
        }
    }
}

