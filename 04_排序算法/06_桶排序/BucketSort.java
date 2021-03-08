import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {

    public static double[] sort(double[] array) {
        //获取数列的最大值、最小值及差值
        double max = array[0];
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
        double d = max - min;

        //初始化桶
        int bucketNum = array.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<>());
        }

        //遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(array[i]);
        }

        //对每个桶内部进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            //JDK底层采用了归并排序或归并的优化版本
            Collections.sort(bucketList.get(i));
        }

        //输出全部元素
        double[] sortedArray = new double[array.length];
        int index = 0;
        for (LinkedList<Double> list : bucketList) {
            for (Double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        double[] array = new double[]{4.12, 6.421, 0.0023, 3.0, 2.123, 8.122, 4.12, 10.09};
        System.out.println("原数组：" + Arrays.toString(array));
        double[] sortedArray = sort(array);
        System.out.println("排序后数组：" + Arrays.toString(sortedArray));
    }
}
