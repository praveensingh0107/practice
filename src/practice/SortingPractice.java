package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingPractice {

    public static Integer[] insertionSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static Integer[] insertionSortRecursive(Integer[] arr) {
        return insertionSortRecursive(arr, arr.length);
    }

    public static Integer[] insertionSortRecursive(Integer[] arr, int n) {
        if (n <= 1) {
            return arr;
        }
        insertionSortRecursive(arr, n - 1);
        int key = arr[n - 1];
        int j;
        for (j = n - 2; j >= 0 && arr[j] > key; j--) {
            arr[j + 1] = arr[j];
        }
        arr[j + 1] = key;
        return arr;
    }

    public static Integer[] mergeSort(Integer[] arr) {
        Integer[] base = Arrays.copyOf(arr, arr.length);
        mergeSort(base, arr, 0, arr.length - 1);
        return arr;
    }

    public static void mergeSort(Integer[] base, Integer[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(base, arr, l, mid);
            mergeSort(base, arr, mid + 1, r);
            merge(base, arr, l, mid, r);
        }
    }

    private static void merge(Integer[] base, Integer[] arr, int l, int mid, int r) {
        int i = l, j = mid + 1, k = l;
        while (i < mid + 1 && j < r + 1) {
            if (base[i] <= base[j]) {
                arr[k] = base[i];
                i++;
            } else {
                arr[k] = base[j];
                j++;
            }
            k++;
        }
        while (i < mid + 1) {
            arr[k] = base[i];
            i++;
            k++;
        }
        while (j < r + 1) {
            arr[k] = base[j];
            j++;
            k++;
        }
        System.arraycopy(arr, l, base, l, r - l + 1);
    }

    public static Integer[] heapSort(Integer[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        //Arrays.stream(arr).map(x -> x + ", ").forEach(System.out::print);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
        return arr;
    }

    private static void heapify(Integer[] arr, int n, int i) {
        int l = 2 * i + 1;
        int r = l + 1;
        int largest = i;
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {38, 27, 43, 3, 9, 82, 10};
        Integer[] arr1 = new Integer[arr.length];
        Integer[] arr2 = new Integer[arr.length];
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        List<Integer> list = Arrays.asList(arr);
        //arr1 = insertionSort(arr1);
        //arr1 = insertionSortRecursive(arr1);
        arr1 = mergeSort(arr1);
        List<Integer> list1 = Arrays.asList(arr1);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list1);
        arr2 = heapSort(arr2);
        List<Integer> list2 = Arrays.asList(arr2);
        System.out.println(list2);
    }

}
