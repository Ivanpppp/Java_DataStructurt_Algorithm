package Ivan.sort;

public class insertSort {
    public static void main(String[] args) {
        int arr[] = {1, -1, 3, -4, -5, 5};
/*        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int index = i - 1;
            while (index >= 0 && insertValue < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = insertValue;
        }*/
        InsertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    public static void InsertSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int index = i - 1;
            while (index >= 0 && temp < arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = temp;
        }
    }
}
