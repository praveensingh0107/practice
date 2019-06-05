package practice;

public class kadanesalgo {

    public static int kadanes(int[] arr) {
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        System.out.println(kadanes(arr));
        arr = new int[] {-1, -2, -3};
        System.out.println(kadanes(arr));
    }

}
