package practice;

import java.util.Stack;

public class StackMinElement {
    Stack<Integer> stack = new Stack<>();
    int minElement = Integer.MAX_VALUE;

    public void push(int x) {
        if (stack.isEmpty()) {
            minElement = x;
            stack.push(x);
        } else if (x > minElement) {
            stack.push(x);
        } else {
            stack.push(2*x - minElement);
            minElement = x;
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        } else if (stack.peek() > minElement) {
            return stack.pop();
        } else {
            int val = minElement;
            minElement = 2*minElement - stack.peek();
            stack.pop();
            return val;
        }
    }
    public int getMinElement() {
        return minElement;
    }

    public static void main(String[] args) {
        StackMinElement obj = new StackMinElement();
        obj.push(4); obj.push(3);
        //System.out.println("min: " + obj.getMinElement());
        obj.push(5); obj.push(1);
        System.out.println("min: " + obj.getMinElement());
        System.out.println("pop: " + obj.pop());
        System.out.println("min: " + obj.getMinElement());
        System.out.println("pop: " + obj.pop());
        System.out.println("min: " + obj.getMinElement());
        System.out.println("pop: " + obj.pop());
        System.out.println("min: " + obj.getMinElement());
    }
}
