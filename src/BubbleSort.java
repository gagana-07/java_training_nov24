import static java.util.Collections.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 1, 9};
        int[] result = sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(result[i]);
        }
    }

    public static int[] sort(int[] array) {
        int len = array.length;
        for (int k = 0; k < len - 1; k++) {
            for (int i = 0; i < len - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }

            }
        }
        return array;
    }
}






   