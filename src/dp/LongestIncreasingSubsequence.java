package dp;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {

    public static int LISLength(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        Integer[] list = new Integer[arr.size()];
        Arrays.fill(list, 1);
        for (int i = 1; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i)) {
                    list[i] = Math.max(list[i], 1 + list[j]);
                }
            }

        }
        System.out.println(Arrays.toString(list));
        //Arrays.stream(list).map(x -> x + ", ").forEach(System.out::print);
        return Arrays.stream(list).max((x, y) -> x - y).get();

    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(10, 22, 9, 33, 21, 50, 41, 60);
        System.out.println(LISLength(arr));
    }

}
