package Ivan.sort;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {1, -1, 3, -4, -5, 5};
/*        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }*/
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void selectSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < n; j++) {
                if(min > arr[j]){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

    }
}
