public class MyArray2 {
    private int[] array;
    private int size;

    public MyArray2(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    /**
     * 数组插入元素
     *
     * @param index
     * @param element
     */
    public void insert(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }

        if (size >= array.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = element;
        size++;
        System.out.println("数据插入");
    }

    /**
     * 删除元素
     *
     * @param index
     * @return
     */
    public int delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
        }
        int deletedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return deletedElement;
    }

    /**
     * 数组扩容
     */
    private void resize() {
        System.out.println("数组扩容");
        int[] arrayNew = new int[array.length * 2];
        //从旧数组复制到新数组
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        array = arrayNew;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        MyArray2 myArray = new MyArray2(4);
        myArray.insert(0, 2);
        myArray.insert(1, 3);
        myArray.insert(2, 4);
        myArray.insert(3, 7);
        myArray.insert(1, 9);

        myArray.output();
    }

}
