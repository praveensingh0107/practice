package array;

import java.util.List;
import java.util.Stack;

public class LargestRectangleAreaInHistogram {
    public int getMaxArea(List<Integer> list) {
        if (list == null || list.isEmpty())
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;
        for (int i = 1; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i) < list.get(stack.peek())) {
                int j = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int area = (i - leftIndex - 1) * list.get(j);
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            /*int j = stack.pop();
            int rightIndex = list.size();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int area = list.get(j) * (rightIndex - leftIndex - 1);
            maxArea = Math.max(area, maxArea);*/
            int area = list.get(stack.pop()) * (list.size() - (stack.isEmpty() ?
                    -1 :
                    (stack.peek())) -1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(6, 2, 5, 4, 5, 1, 6);
        LargestRectangleAreaInHistogram obj = new LargestRectangleAreaInHistogram();
        System.out.println(obj.getMaxArea(list));
    }
}
