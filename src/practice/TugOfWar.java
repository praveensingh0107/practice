package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TugOfWar {

    public static List<ArrayList<Integer>> tugOfWar(Integer[] arr) {
        List<ArrayList<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return result;
        if (arr.length == 1) {
            ArrayList<Integer> list = new ArrayList<>(1);
            list.add(arr[0]);
            result.add(list);
            list = new ArrayList<>(0);
            result.add(list);
            return result;
        }
        int all_sum = Arrays.stream(arr).mapToInt(Integer::intValue).sum();
        boolean[] isElementsIncluded = new boolean[arr.length];
        boolean[] soln = new boolean[arr.length];
        tugOfWarUtil(arr, all_sum, 0, 0, isElementsIncluded, 0, soln, Integer.MAX_VALUE);
        ArrayList<Integer> sub1 = new ArrayList<>();
        ArrayList<Integer> sub2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (soln[i]) {
                sub1.add(arr[i]);
            } else {
                sub2.add(arr[i]);
            }
        }
        result.add(sub1);
        result.add(sub2);
        return result;
    }

    private static int tugOfWarUtil(Integer[] arr, int all_sum, int noOfIncludedElements,
            int currentSum, boolean[] isElementsIncluded, int currentIndex, boolean[] soln,
            int minDiff) {
        if (currentIndex == arr.length)
            return minDiff;
        // IF current element needs not to be added to subset 1;
        int diff = tugOfWarUtil(arr, all_sum, noOfIncludedElements, currentSum, isElementsIncluded,
                currentIndex + 1, soln, minDiff);
        if (diff < minDiff) {
            minDiff = diff;
        }
        currentSum += arr[currentIndex];
        isElementsIncluded[currentIndex] = true;
        noOfIncludedElements++;
        if (noOfIncludedElements == arr.length / 2) {
            //diff between sum of subset 1 and sum of subset 2
            int currDiff = Math.abs((all_sum - currentSum) - currentSum);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                for (int i = 0; i < arr.length; i++) {
                    soln[i] = isElementsIncluded[i];
                }
            }
        } else {
            minDiff = tugOfWarUtil(arr, all_sum, noOfIncludedElements, currentSum,
                    isElementsIncluded, currentIndex + 1, soln, minDiff);
        }
        isElementsIncluded[currentIndex] = false;
        return minDiff;
    }

    public static void main(String[] args) {
        Integer arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        List<ArrayList<Integer>> res = tugOfWar(arr);
        System.out.println(res);
        int sum1 = res.get(0).stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);
        int sum2 = res.get(1).stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum2);

    }

}
