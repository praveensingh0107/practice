package intbit.binarysearch;

import java.util.List;

/**
 * There are two sorted array A and B of size m and n respectively.
 * <p>
 * Find the median of the two sorted array ( The median of the array formed by merging both the array ).
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * Sample Input
 * <p>
 * A : [1 4 5]
 * B : [2 3]
 * <p>
 * Sample Output
 * <p>
 * 3
 * NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element.
 * For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5
 */
public class MedianOfArrays {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() <= b.size())
            return getMedian(a, 0, a.size() - 1, b, 0, b.size() - 1);
        else
            return getMedian(b, 0, b.size() - 1, a, 0, a.size() - 1);
    }

    private double getMedian(List<Integer> a, int al, int ar, List<Integer> b, int bl, int br) {
        int m = ar - al + 1;
        int n = br - bl + 1;
        if (m == 0)
            return getSingleMedian(b, bl, br);
        if (m == 1) {
            if (n == 1)
                return mo2(a.get(al), b.get(bl));
            else if (n % 2 == 1)
                return mo2(b.get(bl + n / 2),
                        mo3(b.get(bl + n / 2 - 1), b.get(bl + n / 2 + 1), a.get(al)));
            else
                return mo3(b.get(bl + n / 2 - 1), b.get(bl + n / 2), a.get(al));
        } else if (m == 2) {
            if (n == 2)
                return mo4(a.get(al), a.get(ar), b.get(bl), b.get(br));
            else if (n % 2 == 1)
                return mo3(b.get(bl + n / 2), Math.max(b.get(bl + n / 2 - 1), a.get(al)),
                        Math.min(b.get(bl + n / 2 + 1), a.get(ar)));
            else
                return mo4(b.get(bl + n / 2), b.get(bl + n / 2 - 1),
                        Math.max(b.get(bl + n / 2 - 2), a.get(al)),
                        Math.min(b.get(bl + n / 2 + 1), a.get(ar)));
        } else {
            int indexA = (ar - al) / 2;
            int indexB = (br - bl) / 2;
            if (a.get(al + indexA) <= b.get(bl + indexB)) {
                return getMedian(a, al + indexA, ar, b, bl, br - indexA);
            }
            return getMedian(a, al, ar - indexA, b, bl + indexA, br);
        }
    }

    private double mo4(double a, double b, double c, double d) {
        return (a + b + c + d - Math.max(a, Math.max(b, Math.max(c, d))) - Math
                .min(a, Math.min(b, Math.min(c, d)))) / 2.0;
    }

    private double mo3(double a, double b, double c) {
        return a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    private double mo2(double a, double b) {
        return (a + b) / 2.0;
    }

    private double getSingleMedian(List<Integer> b, int bl, int br) {
        int n = (br - bl + 1) / 2;
        if (n % 2 == 1)
            return b.get(bl + n / 2);
        else
            return mo2(b.get(bl + n / 2 - 1), b.get(bl + n / 2));
    }

    public static void main(String[] args) {
        List<Integer> a = List.of(1, 4, 5);
        List<Integer> b = List.of(2, 3, 6, 7, 8);
        MedianOfArrays medianOfArrays = new MedianOfArrays();
        System.out.println(medianOfArrays.findMedianSortedArrays(a, b));
    }
}
