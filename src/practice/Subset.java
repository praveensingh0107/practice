package practice;

import java.util.ArrayList;

public class Subset {

    public static ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set) {
        if (set == null) {
            return null;
        } else {
            return getSubset(set, set.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (index == -1) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubset(set, index - 1);
            ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<>();
            for (ArrayList<Integer> arr : allSubsets) {
                ArrayList<Integer> newArr = new ArrayList<>();
                newArr.addAll(arr);
                newArr.add(set.get(index));
                moreSubset.add(newArr);
            }
            allSubsets.addAll(moreSubset);
        }
        return allSubsets;
    }

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        System.out.println(set);
        System.out.println(getSubset(set));
    }

}
