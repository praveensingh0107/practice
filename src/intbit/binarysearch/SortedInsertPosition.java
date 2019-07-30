package intbit.binarysearch;

import java.util.List;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 *
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SortedInsertPosition {
    public int searchInsert(List<Integer> a, int b) {
        int l = 0, r = a.size() -1;
        int mid;
        while (l <= r) {
            mid = l + (r-l)/2;
            if (a.get(mid) == b) {
                return mid;
            } else if (a.get(mid) < b) {
                if ((mid == a.size()-1) || (a.get(mid+1) > b)) {
                    return mid + 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (mid == 0 || a.get(mid-1) < b) {
                    return mid;
                } else {
                    r = mid -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SortedInsertPosition obj = new SortedInsertPosition();
        List<Integer> a = List.of(1,3,5,6);
        System.out.println(obj.searchInsert(a,5));
        System.out.println(obj.searchInsert(a,2));
        System.out.println(obj.searchInsert(a,7));
        System.out.println(obj.searchInsert(a,0));
    }
}
