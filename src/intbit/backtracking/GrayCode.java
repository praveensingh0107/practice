package intbit.backtracking;

import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * There might be multiple gray code sequences possible for a given n.
 * Return any such sequence.
 * */
public class GrayCode {

    public ArrayList<Integer> grayCode(int a) {
        return solve(a);
    }

    private ArrayList<Integer> solve(int a) {
        if (a == 0) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        } else {
            int temp;
            ArrayList<Integer> res = solve(a-1);
            for (int i = res.size() -1; i >= 0; i--) {
                temp = res.get(i);
                temp = temp | 1<<a-1;
                res.add(temp);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        GrayCode obj = new GrayCode();
        ArrayList<Integer> grayCode = obj.grayCode(3);
        System.out.println(grayCode);
        grayCode.forEach(x -> System.out.println(Integer.toBinaryString(x)));
    }
}
