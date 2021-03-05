import java.util.Arrays;

public class QuickSort2 {

    /**
     * 快速排序（单边循环法）
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    public static void sort(int[] arr, int startIndex, int endIndex) {
        //递归结束条件：startIndex大于等于endIndex时
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        //根据基准元素，分成两部分进行递归排序
        sort(arr, startIndex, pivotIndex - 1);
        sort(arr, startIndex + 1, endIndex);
    }

    /**
     * 分治（单边循环法）
     *
     * @param arr
     * @param startIndex
     * @param endIndex
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        //取第2个位置，（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1};
        System.out.println("原数组：" + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("排序后数组：" + Arrays.toString(arr));
    }
}
