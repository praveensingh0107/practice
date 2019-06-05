package intbit.math;

/**
 * Given a column title as appears in an Excel sheet, return its corresponding column number.
 * Example:
 * <p>
 * A -> 1
 * <p>
 * B -> 2
 * <p>
 * C -> 3
 * <p>
 * ...
 * <p>
 * Z -> 26
 * <p>
 * AA -> 27
 * <p>
 * AB -> 28
 */
public class ExcelColumnNumber {
    public int titleToNumber(String a) {
        if (a == null || a.length() == 0)
            return -1;
        int res = 0, pow = 1;
        for (int i = a.length() - 1; i >= 0; i--) {
            res += (a.charAt(i) - 'A' + 1) * pow;
            pow *= 26;
        }
        return res;
    }

    public static void main(String[] args) {
        ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
        System.out.println(excelColumnNumber.titleToNumber("AB"));
        System.out.println(excelColumnNumber.titleToNumber("A"));
    }
}
