package intbit.string;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * A valid IP address must be in the form of A.B.C.D, where A,B,C and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
 *
 * Example:
 *
 * Given “25525511135”,
 *
 * return [“255.255.11.135”, “255.255.111.35”]. (Make sure the returned strings are sorted in order)
 */
public class RestoreIPAddress {

    /**
     *
     * @param a string
     * @return ArrayList
     */
    public ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> res = new ArrayList<>();
        if (a.length() < 4)
            return res;
        char[] arr = new char[a.length()+3];
        restoreIpUtil(res, a, 0, arr, 0, 0);
        return res;
    }

    private void restoreIpUtil(ArrayList<String> res, String str, int strIndex, char[] arr, int arrIndex, int partCount) {
        if (partCount == 3) {
            if (str.length() - strIndex > 0 && str.length() - strIndex < 4) {
                if (str.charAt(strIndex) == '0' && strIndex + 1 < str.length()) {
                    return;
                } else {
                    StringBuilder sb = new StringBuilder();
                    while (strIndex < str.length()) {
                        if (!isValid(sb.append(str.charAt(strIndex))))
                            return;
                        arr[arrIndex] = str.charAt(strIndex);
                        strIndex++; arrIndex++;
                    }
                    res.add(String.valueOf(arr));
                }
            }
        } else {
            if (str.charAt(strIndex) == '0') {
                arr[arrIndex] = '0';
                arr[arrIndex + 1] = '.';
                restoreIpUtil(res, str, strIndex + 1, arr, arrIndex + 2, partCount + 1);
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    if (strIndex + i < str.length() && isValid(sb.append(str.charAt(strIndex + i)))) {
                        arr[arrIndex + i] = str.charAt(strIndex + i);
                        arr[arrIndex + i + 1] = '.';
                        restoreIpUtil(res, str, strIndex + i + 1, arr, arrIndex + i + 2, partCount + 1);
                    }
                }
            }
        }
    }

    private boolean isValid(StringBuilder sb) {
        return (Integer.parseInt(sb.toString()) <= 255);
    }

    public static void main(String[] args) {
        RestoreIPAddress obj = new RestoreIPAddress();
        String str = "25525511135";
        System.out.println(obj.restoreIpAddresses(str));
    }
}
