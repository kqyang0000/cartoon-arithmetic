public class IsPower2 {

    public static boolean isPowerOf2(int num) {
        int tmp = 1;
        while (tmp <= num) {
            if (tmp == num) {
                return true;
            }
            tmp = tmp << 1;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(32));
        System.out.println(isPowerOf2(19));
    }
}
