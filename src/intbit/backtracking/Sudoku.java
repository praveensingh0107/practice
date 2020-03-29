package intbit.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'
 * You may assume that there will be only one unique solution.
 *
 *
 *
 * A sudoku puzzle,
 *
 *
 *
 * and its solution numbers marked in red.
 *
 * Example :
 *
 * For the above given diagrams, the corresponding input to your program will be
 *
 * [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
 * and we would expect your program to modify the above array of array of characters to
 *
 * [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284],
 * */
public class Sudoku {

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {

    }

    public static void main(String[] args) {
        List<Character> list1 = List.of('5', '3', '.', '.', '7', '.', '.', '.', '.');
        ArrayList<Character> row1 = new ArrayList<>(list1);
        List<Character> list2 = List.of('6', '.', '.', '1', '9', '5', '.', '.', '.');
        ArrayList<Character> row2 = new ArrayList<>(list2);
        List<Character> list3 = List.of('.', '9', '8', '.', '.', '.', '.', '6', '.');
        ArrayList<Character> row3 = new ArrayList<>(list3);
        List<Character> list4 = List.of('8', '.', '.', '.', '6', '.', '.', '.', '3');
        ArrayList<Character> row4 = new ArrayList<>(list4);
        List<Character> list5 = List.of('4', '.', '.', '8', '.', '3', '.', '.', '1');
        ArrayList<Character> row5 = new ArrayList<>(list5);
        List<Character> list6 = List.of('7', '.', '.', '.', '2', '.', '.', '.', '6');
        ArrayList<Character> row6 = new ArrayList<>(list6);
        List<Character> list7 = List.of('.', '6', '.', '.', '.', '.', '2', '8', '.');
        ArrayList<Character> row7 = new ArrayList<>(list7);
        List<Character> list8 = List.of('.', '.', '.', '4', '1', '9', '.', '.', '5');
        ArrayList<Character> row8 = new ArrayList<>(list8);
        List<Character> list9 = List.of('.', '.', '.', '.', '8', '.', '.', '7', '9');
        ArrayList<Character> row9 = new ArrayList<>(list9);
        ArrayList<ArrayList<Character>> lists = new ArrayList<>();
        lists.add(row1); lists.add(row2); lists.add(row3);
        lists.add(row4); lists.add(row5); lists.add(row6);
        lists.add(row7); lists.add(row8); lists.add(row9);
        System.out.println(lists);
    }
}
