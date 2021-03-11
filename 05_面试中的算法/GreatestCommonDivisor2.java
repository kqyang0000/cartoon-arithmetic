public class GreatestCommonDivisor2 {

    public static int getGreatestCommonDivisor2(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        return getGreatestCommonDivisor2(big % small, small);
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor2(25, 5));
        System.out.println(getGreatestCommonDivisor2(100, 80));
        System.out.println(getGreatestCommonDivisor2(27, 14));
    }
}
