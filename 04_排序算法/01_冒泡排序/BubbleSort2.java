import java.util.Arrays;

public class BubbleSort2 {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - 1 - i; j++) {
                int temp = 0;
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    //因为有元素进行交换，所以不是有序的
                    isSorted = false;
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        System.out.println("原数组：" + Arrays.toString(array));
        sort(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }
}
