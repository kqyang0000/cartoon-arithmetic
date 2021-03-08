import java.util.Arrays;

public class CountSort {

    /**
     * 计数排序
     *
     * @param array
     * @return
     */
    public static int[] countSort(int[] array) {
        //得到数列的最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //根据数列最大值确定统计数组的长度
        int[] countArray = new int[max + 1];
        //遍历数列，填充统计数组
        for (int i = 0; i < array.length; i++) {
            countArray[array[i]]++;
        }
        //遍历统计数组，输出结果
        int index = 0;
        int[] sortedArray = new int[array.length];
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 4, 6, 5, 3, 2, 8, 1, 7, 5, 6, 0, 10};
        System.out.println("原数组：" + Arrays.toString(arr));
        int[] sortedArr = countSort(arr);
        System.out.println("排序后数组：" + Arrays.toString(sortedArr));
    }
}
