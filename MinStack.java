
import java.util.*;

public class MinStack {

    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currMin = stack.peek()[1];
            stack.push(new int[]{val, Math.min(val, currMin)});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        System.out.println(stack.getMin());
        stack.pop();
        stack.push(-1);
        stack.push(-2);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
