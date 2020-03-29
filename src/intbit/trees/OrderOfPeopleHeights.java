package intbit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Order of People Heights
 * Asked in:
 * Google
 * You are given the following :
 * <p>
 * A positive number N
 * Heights : A list of heights of N persons standing in a queue
 * Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
 * You need to return list of actual order of persons’s height
 * <p>
 * Consider that heights will be unique
 * <p>
 * Example
 * <p>
 * Input :
 * Heights: 5 3 2 6 1 4
 * InFronts: 0 1 2 0 3 2
 * Output :
 * actual order is: 5 3 2 1 6 4
 * So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.
 * <p>
 * For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.
 * <p>
 * You can do similar inference for other people in the list.
 */
public class OrderOfPeopleHeights {
    public ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        IntStream.range(0, A.size()).forEach(i -> map.put(A.get(i), B.get(i)));
        Integer[] arr = new Integer[A.size()];
        Arrays.fill(arr, -1);
        map.entrySet().forEach(x -> arr[getIndex(arr, x.getValue())] = x.getKey());
        return new ArrayList<>(Arrays.asList(arr));
    }

    private int getIndex(Integer[] arr, int inFronts) {
        int count = 0;
        int index = -1;
        while (count != inFronts + 1) {
            index++;
            if (arr[index] == -1)
                count++;
        }
        return index;
    }

    public ArrayList<Integer> order_(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < A.size(); i++) {
            map.put(A.get(i), B.get(i));
        }
        SegmentTree segmentTree = new SegmentTree(A.size());

        Integer[] arr = new Integer[A.size()];
        map.entrySet().forEach(x -> {
            int index = segmentTree.query(x.getValue() + 1);
            segmentTree.update(0, index);
            arr[index] = x.getKey();
        });
        return new ArrayList<>(Arrays.asList(arr));
    }

    static class SegmentTree {
        int[] treeArr;

        int arrSize;

        int treeSize;

        SegmentTree(int n) {
            arrSize = n;
            int x = (int) Math.ceil(Math.log(n) / Math.log(2));
            treeSize = 2*(int) Math.pow(2, x) -1;
            treeArr = new int[treeSize];
            build(0, n - 1, 0);
        }

        private int build(int l, int r, int index) {
            if (l == r) {
                treeArr[index] = 1;
                return treeArr[index];
            } else {
                int mid = getMid(l, r);
                treeArr[index] = build(l, mid, getLeft(index)) + build(mid + 1, r, getRight(index));
                return treeArr[index];
            }
        }

        public void update(int newVal, int arrIndex) {
            updateUtil(newVal, arrIndex, 0, arrSize - 1, 0);
        }

        private void updateUtil(int newVal, int arrIndex, int l, int r, int treeIndex) {
            if (l > r)
                return;
            else if (l == r) {
                treeArr[treeIndex] = newVal;
            } else {
                int mid = getMid(l, r);
                if (arrIndex <= mid)
                    updateUtil(newVal, arrIndex, l, mid, getLeft(treeIndex));
                else
                    updateUtil(newVal, arrIndex, mid + 1, r, getRight(treeIndex));
                treeArr[treeIndex] = treeArr[getLeft(treeIndex)] + treeArr[getRight(treeIndex)];
            }
        }

        public int query(int sum) {
            return query(sum, 0, arrSize-1, 0);
        }

        public int query(int sum, int l , int r, int treeIndex) {
            if (l > r)
                return 0;
            if(l == r)
                return l;
            int leftSum = treeArr[getLeft(treeIndex)];
            if (leftSum >= sum) {
                return query(sum, l , getMid(l, r), getLeft(treeIndex));
            }
            return query(sum-leftSum, getMid(l, r) + 1, r, getRight(treeIndex));
        }

        private int getLeft(int treeIndex) {
            return 2*treeIndex + 1;
        }

        private int getRight(int treeIndex) {
            return 2*treeIndex + 2;
        }

        private int getMid(int l, int r) {
            return l + (r - l)/2;
        }
    }

    public static void main(String[] args) {
        List<Integer> hs = List.of(5, 3, 2, 6, 1, 4);
        List<Integer> inf = List.of(0, 1, 2, 0, 3, 2);
        ArrayList<Integer> heights = new ArrayList<>(hs);
        ArrayList<Integer> inFronts = new ArrayList<>(inf);
        OrderOfPeopleHeights obj = new OrderOfPeopleHeights();
        System.out.println(obj.order(heights, inFronts));
        System.out.println(obj.order_(heights, inFronts));
    }
}
