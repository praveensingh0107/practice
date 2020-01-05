package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find next greater number with same set of digits
 * Given a number n, find the smallest number that has same set of digits as n and is greater than n. If n is the greatest possible number with its set of digits, then print “not possible”.
 * Examples:
 * For simplicity of implementation, we have considered input number as a string.
 *
 * Input:  n = "218765"
 * Output: "251678"
 *
 * Input:  n = "1234"
 * Output: "1243"
 *
 * Input: n = "4321"
 * Output: "Not Possible"
 *
 * Input: n = "534976"
 * Output: "536479"
 */
public class NextGreaterElement {

    public void findNext(Integer[] arr) {
        int i = arr.length-1, j = 0;
        boolean isFound = false;
        outer:
        while (i > 0) {
            for (j = i-1; j>=0; j--) {
                if (arr[i] > arr[j]) {
                    isFound = true;
                    break outer;
                }
            }
            i--;
        }

        if (!isFound) {
            System.out.println("Not Possible");
        }
        else {
            swap(arr, i , j);
            // sub array next to j should be sorted.
            Arrays.sort(arr, j + 1,  arr.length);
        }
    }

    public void findNext1(Integer[] arr) {
        int index = findIdxOEElemSmallThanSubsequentArray(arr);
        if (index == - 1) {
            System.out.println("Not Possible");
        } else {
            int nextIdx = findIdxOfNxtGrtrElmntThanCurIdxElmnt(arr, index);
            swap(arr, index, nextIdx);
            Arrays.sort(arr, index + 1, arr.length);
        }
    }
    private int findIdxOEElemSmallThanSubsequentArray(Integer[] arr) {
        for (int i = arr.length-1; i > 0; i--) {
            if (arr[i-1] < arr[i]) {
                return i-1;
            }
        }
        return -1;
    }

    private int findIdxOfNxtGrtrElmntThanCurIdxElmnt(Integer[] arr, int currentIndex) {
        //int minIdx = -1; int minVal = Integer.MAX_VALUE;
        for (int i = arr.length -1; i > currentIndex; i--) {
            if (arr[i] > arr[currentIndex]) {
                return i;
            }
        }
        return currentIndex;
    }

    private void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        NextGreaterElement obj =new NextGreaterElement();
        Integer[] arr = {2, 1, 8, 6, 7, 5};
        obj.findNext(arr);
        List<Integer> collect = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println(collect);

        Integer[] arr1 = {2, 1, 8, 6, 7, 5};
        obj.findNext1(arr1);
        List<Integer> collect1 = Arrays.stream(arr1).collect(Collectors.toList());
        System.out.println(collect1);

        Integer[] arr2 = {2, 1, 8, 7, 6, 5};
        obj.findNext1(arr2);
        List<Integer> collect2 = Arrays.stream(arr2).collect(Collectors.toList());
        System.out.println(collect2);

        Integer[] arr3 = {4, 3, 2, 1};
        obj.findNext1(arr3);
        List<Integer> collect3 = Arrays.stream(arr3).collect(Collectors.toList());
        System.out.println(collect3);

        Integer[] arr4 = {1, 2, 3, 4};
        obj.findNext1(arr4);
        List<Integer> collect4 = Arrays.stream(arr4).collect(Collectors.toList());
        System.out.println(collect4);

    }
}
