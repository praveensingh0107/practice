package intbit.dp;

import java.util.List;

/**
 * Best Time to Buy and Sell Stocks III
 * Asked in:
 * Amazon
 * Facebook
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most 2 transactions.
 * <p>
 * Return the maximum possible profit.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument is an integer array, A.
 * Output Format:
 * <p>
 * Return an integer, representing the maximum possible profit.
 * Constraints:
 * <p>
 * 1 <= length(A) <= 7e5
 * 1 <= A[i] <= 1e7
 * Examples:
 * <p>
 * Input 1:
 * A = [1, 2, 1, 2]
 * <p>
 * Output 1:
 * 2
 * <p>
 * Explanation 1:
 * Day 0 : Buy
 * Day 1 : Sell
 * Day 2 : Buy
 * Day 3 : Sell
 * <p>
 * Input 2:
 * A = [7, 2, 4, 8, 7]
 * <p>
 * Output 2:
 * 6
 * <p>
 * Explanation 2:
 * Day 1 : Buy
 * Day 3 : Sell
 */
public class BestTimeToBuySellStocks3 {

    public int maxProfit(final List<Integer> A) {
        if (A == null || A.size() < 2)
            return 0;
        return maxProfit(A, 0, A.size() - 1);
    }

    private int maxProfit(List<Integer> A, int l, int r) {
        if (l >= r)
            return 0;
        int maxDiff = 0;
        for (int i = l + 1; i <= r; i++) {
            maxDiff = Math.max(maxDiff, getMaxDiff(A, l, i) + getMaxDiff(A, i + 1, r));
        }
        return maxDiff;
    }

    private int maxProfitDP(List<Integer> A) {
        if (A == null || A.size() < 2)
            return 0;
        int[] max_from_left = new int[A.size()];
        int[] max_from_right = new int[A.size()];
        int min = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
            max_from_left[i] = Math.max(max_from_left[i - 1], A.get(i) - min);
        }
        int max = A.get(A.size() - 1);
        for (int i = A.size() - 2; i >= 0; i--) {
            max = Math.max(max, A.get(i));
            max_from_right[i] = Math.max(max_from_right[i + 1], max - A.get(i));
        }
        int maxDiff = 0;
        for (int i = 0; i < A.size(); i++) {
            maxDiff = Math.max(maxDiff, max_from_left[i] + max_from_right[i]);
        }
        return maxDiff;
    }

    private int getMaxDiff(List<Integer> A, int l, int r) {
        if (l >= r)
            return 0;
        int maxDiff = 0;
        int lastValue = A.get(l);
        for (int i = l + 1; i <= r; i++) {
            maxDiff = Math.max(maxDiff, A.get(i) - lastValue);
            if (lastValue >= A.get(i)) {
                lastValue = A.get(i);
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        BestTimeToBuySellStocks3 obj = new BestTimeToBuySellStocks3();
        List<Integer> list1 = List.of(1, 2, 1, 2);
        //System.out.println(obj.getMaxDiff(list1, 0, list1.size()-1));
        System.out.println(obj.maxProfitDP(list1));
        List<Integer> list2 = List.of(7, 2, 4, 8, 7);
        //System.out.println(obj.getMaxDiff(list2, 0, list2.size()-1));
        System.out.println(obj.maxProfitDP(list2));
        List<Integer> list3 = List.of(5, 1, 3, 7, 2, 10);
        //System.out.println(obj.getMaxDiff(list3, 0, list3.size()-1));
        System.out.println(obj.maxProfitDP(list3));
        List<Integer> list5 = List.of(5, 1, 3, 7, 6, 8, 5, 7);
        System.out.println(obj.maxProfitDP(list5));
        List<Integer> list4 = List
                .of(7551982, 8124939, 4023780, 7868369, 4412570, 2542961, 7380261, 1164290, 7781065,
                        1164599, 2563492, 5354415, 4994454, 2627136, 5933501, 668219, 1821804,
                        7818378, 33654, 4167689, 8652323, 5750640, 9822437, 3466466, 554089,
                        6168826, 335687, 2466661, 8511732, 6288553, 2905889, 7747975, 3744045,
                        1545003, 1008624, 8041203, 7176125, 4321092, 714053, 7200073, 166697,
                        7814651, 3090485, 8318668, 6600364, 3352620, 2430137, 7685821, 1442555,
                        828955, 6540266, 5305436, 116568, 1883410, 7975347, 9629015, 4735259,
                        6559041, 1832532, 5840170, 6983732, 5886179, 1496505, 7241412, 144558,
                        9462840, 8579314, 2488436, 9677478, 7589124, 5636642, 2440601, 1767332,
                        2399786, 6299635, 8534665, 1367339, 805592, 5572668, 6990026, 8465261,
                        4808596, 7641452, 8464860, 3170126, 7403200, 6932907, 3776122, 1313688,
                        3992189, 2382116, 3886952, 349816, 1596435, 7353742, 9964868, 9882224,
                        3818546, 3885458, 1200559, 3910256, 7949895, 463872, 6392805, 9513226,
                        3427933, 3470571, 6225817, 552452, 5567651, 6414423, 6701681, 4725847,
                        894529, 8046603, 426263, 5280891, 9197661, 9764507, 1740413, 9530261,
                        9163599, 7561587, 5848442, 7312422, 4794268, 5793465, 5039382, 5147388,
                        7346933, 4697363, 6436473, 5159752, 2207985, 8256403, 8958858, 6099618,
                        2172252, 3063342, 4324166, 3919237, 8985768, 2703255, 2386343, 3064166,
                        247762, 7271683, 1812487, 7163753, 4635382, 449426, 2561592, 3746615,
                        8741199, 6696192, 606265, 5374062, 3065308, 6918398, 2956279, 8949324,
                        2804580, 3421479, 7846658, 8895839, 8277589, 1262596, 451779, 9972218,
                        6378556, 4216958, 7127258, 8593578, 326883, 4737513, 6578257, 7582654,
                        8675499, 9038961, 7902676, 8874020, 5513073, 631930, 912719, 8394492,
                        1508363, 455175, 9215635, 6813970, 2021710, 5673212, 184474, 4511247,
                        4653238, 2218883, 9669544, 295018, 3694660, 1709444, 4019025, 5047809,
                        45740, 1035395, 8159408, 1557286, 1304144, 6496263, 2094202, 9945315,
                        1905585, 1143081, 6994125, 9609830, 1077628, 3488222, 6299366, 7187139,
                        3883908, 7077292, 3210807, 7328762, 7695314, 1138834, 7689433, 5083719,
                        202831, 8138452, 5495064, 7543763, 1597085, 5429837, 8455839, 6925605,
                        6600884, 3571512, 3422637, 8911245, 3700762, 2338168, 6830853, 2539094,
                        490627, 2294717, 497349, 8297867, 7299269, 4769134, 285033, 4335917,
                        9908413, 152868, 2658658, 3525848, 1884044, 4953877, 8660374, 8989154,
                        888731, 7217408, 2614940, 7990455, 9779818, 1441488, 9605891, 4518756,
                        3705442, 9331226, 404585, 9011202, 7355000, 7461968, 6512552, 2689841,
                        2873446, 256454, 1068037, 8786859, 2323599, 3332506, 2361155, 7476810,
                        5605915, 5950352, 6491737, 8696129, 4637800, 4207476, 9334774, 840248,
                        9159149, 5201180, 7211332, 3135016, 8524857, 4566111, 7697488, 1833291,
                        7227481, 8289951, 2389102, 9102789, 8585135, 1869227, 4082835, 8447466,
                        4985240, 4176179);
        System.out.println(obj.maxProfitDP(list4));
    }
}
