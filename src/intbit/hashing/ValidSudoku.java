package intbit.hashing;

import javax.xml.validation.Validator;
import java.util.HashSet;
import java.util.List;

/**
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
 *
 *
 *
 * The input corresponding to the above configuration :
 *
 * ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 * A partially filled sudoku which is valid.
 *
 *  Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidSudoku {
    public int isValidSudoku(final List<String> A) {
        //int[][] sudoku = new int[A.size()][A.get(0).length()];
        HashSet<Integer>[] rowSets = new HashSet[9];
        HashSet<Integer>[] colSets = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
        }
        HashSet<Integer>[][] internalSquare = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                internalSquare[i][j] = new HashSet<>();
            }
        }
        int val = 0;
        int dotValue = '.';
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).length(); j++) {
                val = A.get(i).charAt(j);
                if (val != dotValue) {
                    if (rowSets[i].contains(val) || colSets[j].contains(val) || internalSquare[i/3][j/3].contains(val))
                        return 0;
                    rowSets[i].add(val);
                    colSets[j].add(val);
                    internalSquare[i/3][j/3].add(val);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        ValidSudoku obj = new ValidSudoku();
        List<String> A = List
                .of("53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6",
                        ".6....28.", "...419..5", "....8..79");
        System.out.println(obj.isValidSudoku(A));
    }
}
