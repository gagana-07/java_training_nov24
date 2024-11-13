package linked;

import java.util.Arrays;
public class BinarySearchDelete {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static int binarySearch(int[] array, int key) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == key) {
                return mid;
            }
            if (array[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static int[] deleteElement(int[] array, int key) {
        int index = binarySearch(array, key);
        if (index == -1) {
            System.out.println("Element not found!");
            return array;
        }
        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }
    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 6, 3};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(array));
        int key = 6;
        int index = binarySearch(array, key);
        if (index != -1) {
            System.out.println("Element " + key + " found at index " + index);
        } else {
            System.out.println("Element " + key + " not found.");
        }
        array = deleteElement(array, key);
        System.out.println("Array after deleting " + key + ":");
        System.out.println(Arrays.toString(array));
    }
}


