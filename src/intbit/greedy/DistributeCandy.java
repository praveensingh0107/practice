package intbit.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Distribute Candy
 * Asked in:
 * Microsoft
 * Flipkart
 * Amazon
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * 1. Each child must have at least one candy.
 * 2. Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p>
 * Input Format:
 * <p>
 * The first and the only argument contains N integers in an array A.
 * Output Format:
 * <p>
 * Return an integer, representing the minimum candies to be given.
 * Example:
 * <p>
 * Input 1:
 * A = [1, 2]
 * <p>
 * Output 1:
 * 3
 * <p>
 * Explanation 1:
 * The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor.
 * So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
 * <p>
 * Input 2:
 * A = [1, 5, 2, 1]
 * <p>
 * Output 2:
 * 7
 * <p>
 * Explanation 2:
 * Candies given = [1, 3, 2, 1]
 */
public class DistributeCandy {
    public int candy(ArrayList<Integer> A) {
        if (A == null || A.size() == 0)
            return 0;
        int[] arr = new int[A.size()];
        arr[0] = 1;
        int count = 1;
        for (int i = 1; i < A.size(); i++) {
            /*if (A.get(i) == A.get(i-1)) {
                arr[i] = count;
            } else */
            if (A.get(i) > A.get(i - 1)) {
                count++;
                arr[i] = count;
            } else {
                count = 1;
                arr[i] = count;
                int j = i;
                while (j >= 1 && A.get(j - 1) > A.get(j) && arr[j - 1] <= arr[j]) {
                    arr[j - 1] += 1;
                    j--;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return Arrays.stream(arr).sum();
    }

    public int candy_editorialSolution(ArrayList<Integer> A) {
        int n = A.size();
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 0; i < n - 1; i++) {
            if (A.get(i + 1) > A.get(i))
                candies[i + 1] = candies[i] + 1;
        }
        for (int i = n - 1; i > 0; i--) {
            if (A.get(i - 1) > A.get(i) && candies[i - 1] <= candies[i])
                candies[i - 1] = candies[i] + 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        DistributeCandy obj = new DistributeCandy();
        System.out.println(obj.candy(new ArrayList<>(List.of(1, 2))));
        System.out.println(obj.candy(new ArrayList<>(List.of(1, 5, 2, 1))));
        System.out.println(obj.candy(new ArrayList<>(List.of(1, 5, 3, 4, 2, 1))));
        System.out.println(obj.candy(new ArrayList<>(List.of(1, 5, 5, 1))));
        List<Integer> list = List
                .of(357, 287, 248, 96, 22, 295, -78, -239, -482, 74, 269, 265, -269, -130, 351, 109,
                        490, 431, -171, 335, 321, -485, 313, -475, -43, 322, -132, 42, -171, 389,
                        493, -444, -265, -458, -71, -395, 134, -233, 211, 356, -330, -336, 274,
                        -193, -421, -163, 29, 329, -466, -60, 96, 432, 171, -385, -52, 120, -403,
                        -325, -97, 100, 61, -80, -82, 426, 263, -256, 476, -390, 444, -148, 414,
                        376, -298, 192, -183, -53, 386, 127, -329, 125, -328, 490, -12, 132, 40,
                        414, 347, 439, 255, -343, -84, 256, 38, -368, 307, 463, 29, -428, -25, -51,
                        -385, 145, 86, 441, 361, 183, -407, -227, -404, -225, -279, -37, 280, -13,
                        -258, -393, 164, 361, 146, -293, 248, -320, -389, -337, 341, -1, -445, -420,
                        414, -63, 328, 120, -462, 318, 500, -358, 233, -165, 274, -388, -393, -48,
                        312, -173, 281, 325, -167, 383, 353, 125, -416, -179, -285, -449, 418, 288,
                        62, -186, 413, -500, 199, 281, -163, -99, 193, -130, 414, 392, 299, 328,
                        156, -247, -85, -455, -274, 54, -161, 82, -265, 311, -129, -143, 45, 308,
                        408, 346, 438, -441, -237, 402, -428, -230, 24, 317, -189, -356, -53, 419,
                        426, -362, 399, 460, 335, 84, 177, 138, 229, 162, 416, -284, -44, -423, -9,
                        -271, 425, -166, -482, -335, -357, 6, -191, 261, 391, -68, 224, 402, -487,
                        -45, 312, 233, -393, 138, -95, -139, -239, 234, 227, -292, 117, -131, -221,
                        373, 97, -456, -292, 460, 238, 280, 43, 206, -8, -117, 274, -10, 182, -77,
                        -421, -309, 493, -355, -88, 14, 67, 112, 177, 426, 468, 449, 263, -208, 198,
                        378, -431, 444, -383);
        System.out.println(obj.candy_editorialSolution(new ArrayList<>(list)));
        List<Integer> list1 = List
                .of(16, -277, -479, 62, 369, -185, 377, 486, -495, 358, 338, -166, -158, 338, -470,
                        473, 68, -152, -301, 425, -246, 428, 369, 232, 198, -440, -366, -284, 89,
                        -279, 195, 58, -411, -75, -487, -345, 447, -253, -466, -326, 260, -494,
                        -443, -335, 301, 191, 184, 161, -403, 89, 89, 197, 316, -91, 285, -457, 232,
                        -313, -355, -333, 80, 86, 182, -484, 116, 16, -428, -234, -347, -133, -161,
                        -260, -285, -464, 214, 446, -324, -70, -44, 199, 105, 465, -487, 271, 13,
                        167, 278, -420, 166, -445, -255, 367, 343, -51, -67, -238, -243, -174, 92,
                        -51, -216, -245, -209, -347, -24, -492, -164, 359, 451, 3, 32, -468, 96,
                        -48, 147, -339, -153, 76, 281, 432, -196, -310, -354, -132, 109, -400, -378,
                        -49, -407, 395, -339, -68, 40, 276, 90, -398, 160, 353, 86, -322, 468, 438,
                        36, 274, -276, 383, 68, 71, 311, 240, -97, 403, 238, -75, 103, 71, -367,
                        -198, 476, 178, -38, 459, 71, 233, 277, 442, 473, -400, 473, -258, -200,
                        289, -92, -286, 42, 458, 436, -341, -65, 252, 62, 182, -88, -210, 303, 244,
                        300, 35, 119, -242, -11, 480, -195, 331, 191, 105, -149, 412, -388, -399,
                        262, -36, -113, 27, 236, -274, 111, 69, 491, 144, 364, -322, -459, 12, 378,
                        26, -298, 250, -92, 424, -388, 273, -487, 233, 409, -289, 98, 242, 84, 36,
                        -86, 288, 18, -271, -243, 342, 118, -348, -394, -372, -16, 363, -337, -125,
                        -120, -340, 91, -294, -72, -335, 50, 384, -159, 308, 258, -246, -124, 69,
                        -431, -297, 276, 371, 331, 69, 333, -476, 132, -65, -369, 314, 357, 99, 281,
                        271, -99, 312, -61, 411, 346, 266, 143, -230, -260, 197, 27, -159, -101,
                        296, 448, 12, -179, 472, 351, -360, -230, -402, 455, -225, 240, 245, -373,
                        -203, 167, -383, -408, 98, 302, -56, 67, 426, -374, 388, -474, 405, -346,
                        -361, -377, 190, -300, -10, -208, 171, -304, -339, 68, -497, 41, 446, 115,
                        -88, -55, -156, 479, -486, -165, -158, -257, 184, -13, -476, -447, 343,
                        -255, 125, 192, -54, 212, -416, -368, -452, -47, -475, 207, 327, 277, -40,
                        18, -223, 305, -370, -245, -449, -37, -500, -195, 338, 276, -358, -58, -143,
                        243, 68, 21, -41, -489, 30, -178, 436, 470, -70, 321, 378, 455, 157, 474,
                        146, 157, 243, -43, 109, 238, 243, 100, 326, -82, -80, -104, 389, -452,
                        -155, -156, -187, -45, 92, -191, 69, 11, 219, -484, 318, -424, 491, -84,
                        -261, -237, 136, 25, 277, 404, 7, 491, 143, 91, -208, -190, -66, 252, 61,
                        147, 37, 40, 209, 374, 375, -461, 131, -216, -432, 294, 390, -229, 451,
                        -484, 211, -75, -273, -137, 473, 422, -156, -184, -150, 458, -28, 62, 50,
                        -400, -40, 266, 21, 346, 391, 46, 472, 6, -305, -305, 170, -293, -127, 377,
                        -415, 491, -437, 16, 400, -168, 309, -447, -417, 444, -253, 479, 82, 340,
                        134, -326, 107, 100, -201, -494, 350, 431, 16, -13, -290, 329, -238, -184,
                        278, -409, -375, -208, -364, 343, -414, 89, -177, -249, -477, 124, -89, 293,
                        401, -435, -210, 349, 98, 77, 92, 250, 30, -251, 112, -12, -85, -156, 82,
                        -31, 267, 22, 105, -449, 131, 496, 395, 288, 435, -361, 167, 181, -57, -404,
                        496, 62, -339, 56, -103, -459, -459, 226, 253, -328, -248, 318, 200, 164,
                        78, -496, 453, -84, -304, -254, 460, -153, -329, -285, -432, -308, 63, -107,
                        402, -470, -184, -351, -7, 54, -123, 256, -395, -280, -391, -300, 81, -269,
                        -170, -19, 462, 110, -264, 297, -250, 44, 465, -160, 485, -313, -497, -167,
                        -372, 464, 0, 138, 110, 269, -491, 203, 250, 400, -301, -445, -480, -133,
                        -349, -499, 499, -133, -171, -57, -147);
        System.out.println(obj.candy(new ArrayList<>(list1)));
    }
}
