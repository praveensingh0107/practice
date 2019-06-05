package dp;

public class GoldMine {

    public static int getMaxGold(int[][] arr) {
        if (arr == null)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < arr.length; r++) {
            max = Math.max(max, getMaxGold(arr, r, 0));
        }
        return max;
    }

    private static int getMaxGold(int[][] arr, int r, int c) {
        if (r == arr.length || r == -1 || c == arr[0].length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int val = 0;
        // right up
        for (int i = -1; i <= 1; i++) {
            val = arr[r][c] + getMaxGold(arr, r + i, c + 1);
            max = Math.max(max, val);
        }
        return max;
    }

    /*public static int getMaxGoldDP(int[][] arr) {
        int[][] goldTable = new int[arr.length][arr[0].length];
        return 0;
    }*/
    public static void main(String[] args) {
        int gold[][] = {{1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};

        System.out.println(getMaxGold(gold));
    }

}
