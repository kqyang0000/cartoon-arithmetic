import java.util.Arrays;

public class MaxPriorityQueue {
    private int[] array;
    private int size;

    public MaxPriorityQueue() {
        //队列初始长度为32
        array = new int[32];
    }

    /**
     * 队列入队
     *
     * @param key
     */
    public void enQueue(int key) {
        //队列长度超出范围，扩容
        if (size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 队列出队
     *
     * @return
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("this queue is empty");
        }
        //获取元素堆顶
        int head = array[0];
        //让最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * 上浮调整
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * 下沉调整
     */
    private void downAdjust() {
        int parentIndex = 0;
        int childIndex = 1;
        int temp = array[parentIndex];
        while (childIndex < size) {
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            //如果父节点大于任何一个孩子的值，直接跳出
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
     * 队列扩容
     */
    private void resize() {
        //队列容量翻倍
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) throws Exception {
        MaxPriorityQueue priorityQueue = new MaxPriorityQueue();
        priorityQueue.enQueue(3);
        priorityQueue.enQueue(5);
        priorityQueue.enQueue(10);
        priorityQueue.enQueue(2);
        priorityQueue.enQueue(7);
        System.out.println("出队元素1：" + priorityQueue.deQueue());
        System.out.println("出队元素2：" + priorityQueue.deQueue());
        priorityQueue.enQueue(9);
        priorityQueue.enQueue(0);
        System.out.println("出队元素3：" + priorityQueue.deQueue());
        System.out.println("出队元素4：" + priorityQueue.deQueue());
    }
}
