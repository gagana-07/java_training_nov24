public class InsertionSort {
    public InsertionSort(int[] arr) {

    }

    public static class insertionSort {
        public insertionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                }
                arr[j + 1] = key;
            }
        }
        public static void main(String[] args) {
            int[] arr = {12, 11, 13, 5, 6};
            System.out.println("Array before sorting:");
            printArray(arr);
            insertionSort insertionSort = new insertionSort(arr);
            System.out.println("Array after sorting:");
            printArray(arr);
        }
        public static void printArray(int[] arr) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

