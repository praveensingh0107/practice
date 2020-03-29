package tree;

import java.util.Arrays;

public class SegmentTreeForSumOfRange {
    private int[] st;

    public SegmentTreeForSumOfRange(int[] arr, int n) {
        int x = (int)Math.ceil(Math.log(n)/Math.log(2));
        int size = 2 * (int)Math.pow(2, x) -1;
        st = new int[size];
        constructUtil(arr, 0 , n-1, 0);
    }

    private int constructUtil(int[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return st[si];
        }
        int mid = getMid(ss, se);
        st[si] = constructUtil(arr, ss, mid, 2 * si + 1) + constructUtil(arr, mid + 1, se,
                2 * si + 2);
        return st[si];
    }

    private int getMid(int ss, int se) {
        return ss + (se - ss)/2;
    }

    public int getSum(int n, int qs, int qe) {
        if (qs < 0 || qe >= n || qs > qe)
            return -1;
        return getSumUtil(qs, qe, 0, n-1, 0);
    }

    private int getSumUtil(int qs, int qe, int ss, int se, int si) {
        if (qs <= ss && qe >= se)
            return st[si];

        if (ss > qe || se < qs) {
            return 0;
        }

        int mid = getMid(ss, se);
        return getSumUtil(qs, qe, ss, mid, 2 * si + 1) + getSumUtil(qs, qe, mid + 1, se,
                2 * si + 2);
    }

    public void updateValue(int[] arr, int n, int i, int newValue) {
        if (i < 0 || i > n-1) {
            System.out.println("invalid input");
        }
        int diff = newValue - arr[i];
        arr[i] = newValue;
        updateValueUtil(0, n-1, i, diff, 0);
    }

    private void updateValueUtil(int ss, int se, int i, int diff, int si) {
        if (i < ss || i > se)
            return;
        st[si] = st[si] + diff;
        if (ss != se) {
            int mid = getMid(ss,se);
            updateValueUtil(ss, mid, i, diff, 2*si + 1);
            updateValueUtil(mid + 1, se, i, diff, 2*si + 2);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(st);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTreeForSumOfRange obj = new SegmentTreeForSumOfRange(arr, n);
        System.out.println(obj);
        System.out.println(obj.getSum(n,3,3));
    }
}
