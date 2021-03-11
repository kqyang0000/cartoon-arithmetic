public class GreatestCommonDivisor3 {

    public static int getGreatestCommonDivisor3(int a, int b) {
        if (a == b) {
            return a;
        }
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        return getGreatestCommonDivisor3(big - small, small);
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor3(25, 5));
        System.out.println(getGreatestCommonDivisor3(100, 80));
        System.out.println(getGreatestCommonDivisor3(27, 14));
    }
}
