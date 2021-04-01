public class MyBitmap {

    //每一个word是一个long类型元素，对应一个64位二进制数组
    private long[] words;
    //Bitmap的位数大小
    private int size;

    public MyBitmap(int size) {
        this.size = size;
        this.words = new long[(getWordIndex(size - 1) + 1)];
    }

    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    /**
     * 把Bitmap某一位设置为true
     *
     * @param bitIndex
     */
    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过Bitmap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    /**
     * 定位Bitmap某一位所对应的word
     *
     * @param bitIndex
     * @return
     */
    private int getWordIndex(int bitIndex) {
        //右移6位，相当于除以64
        return bitIndex >> 6;
    }

    public static void main(String[] args) {
        MyBitmap bitmap = new MyBitmap(128);
        bitmap.setBit(126);
        bitmap.setBit(75);
        System.out.println(bitmap.getBit(126));
        System.out.println(bitmap.getBit(78));
    }
}
