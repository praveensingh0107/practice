package practice;

public class CountAndSay {

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb1 = new StringBuilder();
            for (int j = 0; j < sb.length(); j++) {
                if (j + 1 != sb.length() && sb.charAt(j) == sb.charAt(j + 1)) {
                    count++;
                } else {
                    sb1.append(count).append(sb.charAt(j));
                    count = 1;
                }
            }
            sb = sb1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));

    }

}
