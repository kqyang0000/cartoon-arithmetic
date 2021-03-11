public class RemoveKDigits {

    /**
     * 删除整数的k个数字，获得删除后的最小值
     *
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigits(String num, int k) {
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            //从左向右遍历，找到比自己右侧数字大的数字并删除
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1, num.length());
                    hasCut = true;
                    break;
                }
            }
            //如果没有找到要删除的数字，则删除最后一个数字
            if (!hasCut) {
                num = num.substring(0, num.length() - 1);
            }
        }
        //清除整数左侧的数字0
        int start = 0;
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) != '0') {
                break;
            }
            start++;
        }
        num = num.substring(start, num.length());
        //如果整数的所有数字都被删除了，直接返回0
        if (num.length() == 0) {
            return "0";
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("541270936", 3));
    }
}
