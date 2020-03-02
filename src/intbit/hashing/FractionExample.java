package intbit.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example :
 *
 * Given numerator = 1, denominator = 2, return "0.5"
 * Given numerator = 2, denominator = 1, return "2"
 * Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class FractionExample {

    public String fractionToDecimal_old(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long r = (num%den)*10;
        sb.append(num/den);
        if(r>0)
            sb.append(".");
        int decimalIndex = sb.length()-1;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        int index = 1;
        while (r!= 0) {
            if (map.containsKey(r)) {
                break;
            } else {
                map.put(r, index);
                sb.append(r/den);
                r = (r%den)*10;
            }
            index++;
        }
        if(r!=0) {
            int x = map.get(r);
            sb.insert(decimalIndex+x, "(");
            sb.append(")");
        }
        return sb.toString();
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        if(numerator == 0) {
            result.append('0');
            return result.toString();
        }
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.append('-');
        }
        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        result.append(n/d);
        long r = (n % d) * 10;
        if(r > 0) {
            result.append('.');
        } else {
            return result.toString();
        }
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder fractionalValues= new StringBuilder();
        int index = 0;
        int parenthesesIndex = -1;
        while(r>0) {
            if(map.get(r) != null) {
                parenthesesIndex= map.get(r);
                break;
            } else {
                fractionalValues.append(r/d);
                map.put(r, index);
            }
            r = (r % d)*10;
            index++;
        }
        if(parenthesesIndex != -1) {
            result.append(fractionalValues.substring(0, parenthesesIndex));
            result.append('(');
            result.append(fractionalValues.substring(parenthesesIndex, index));
            result.append(')');
        } else {
            result.append(fractionalValues);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        FractionExample obj = new FractionExample();
        System.out.println(obj.fractionToDecimal(1, 2));
        System.out.println(obj.fractionToDecimal(2, 1));
        System.out.println(obj.fractionToDecimal(2, 3));
    }

}
