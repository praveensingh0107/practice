package practice;

import java.util.List;

/**
 * Rank from Stream: Imagine you are reading in a stream of integers. Periodically, you wish
 * to be able to look up the rank of a number x (the number of values less than or equal to x).
 * Implement the data structures and algorithms to support these operations. That is, implement
 * the method track(int x), which is called when each number is generated, and the method
 * getRankOfNumber(int x), which returns the number of values less than or equal to x (not
 * including x itself).
 * EXAMPLE
 * Stream(in order of appearance):5, 1, 4, 4, 5, 9, 7, 13, 3
 * getRankOfNumber(l) 0
 * getRankOfNumber(3) 1
 * getRankOfNumber(4) 3
 */
public interface RankOfStreams {

    void take(int d);

    int getRankOfNumber(int d);

    static void main(String[] args) {
        RankOfStreams obj = new RankOfStreamsImpl();
        List<Integer> list = List.of(5, 1, 4, 4, 5, 9, 7, 13, 3);
        list.stream().forEach(obj::take);
        System.out.println(obj.getRankOfNumber(1));
        System.out.println(obj.getRankOfNumber(3));
        System.out.println(obj.getRankOfNumber(4));
        System.out.println(obj.getRankOfNumber(5));
        System.out.println(obj.getRankOfNumber(13));
    }

    class RankOfStreamsImpl implements RankOfStreams {
        RankOfNode root = null;

        @Override public void take(int d) {
            if (root == null)
                root = new RankOfNode(d);
            else
                root.insert(d);
        }

        @Override public int getRankOfNumber(int d) {
            if (root == null)
                return -1;
            else
                return root.getRank(d);
        }
    }

    class RankOfNode {
        int data;

        RankOfNode left, right;

        int leftChildCount = 0;

        RankOfNode(int data) {
            this.data = data;
        }

        public void insert(int d) {
            if (d == data) {
                leftChildCount++;
            } else if (d < data) {
                leftChildCount++;
                if (left != null) {
                    left.insert(d);
                } else {
                    left = new RankOfNode(d);
                }
            } else {
                if (right != null)
                    right.insert(d);
                else
                    right = new RankOfNode(d);
            }
        }

        public int getRank(int d) {
            if (data == d) {
                return leftChildCount;
            } else if (d < data) {
                if (left == null)
                    return -1;
                return left.getRank(d);
            } else {
                if (right == null)
                    return -1;
                return leftChildCount + 1 + right.getRank(d);
            }
        }
    }
}
