package intbit.binarysearch;

public class PowerFunction {
    public static int pow(int x, int n, int d) {
        if (x == 0)
            return 0;
        else if (n == 0)
            return 1;

        long a = x;
        long temp = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                temp = (temp * a) % d;
            }
            a = (a * a) % d;
            n >>= 1;
        }
        return (int) ((temp + d) % d);
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 4, 3));
    }
}
