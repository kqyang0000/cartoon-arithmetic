import java.util.Arrays;

public class HeapSort {

    /**
     * 下沉调整
     *
     * @param array
     * @param parentIndex
     * @param length
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            if (temp >= array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序（升序）
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        //把无序数组构建成最大堆
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            downAdjust(array, i, array.length);
        }
        System.out.println(Arrays.toString(array));
        //循环删除堆顶元素，移到集合尾部，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            //最后一个元素和第一个元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //下沉调整最大堆
            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        heapSort(arr);
        System.out.println("数组排序后：" + Arrays.toString(arr));
    }
}
