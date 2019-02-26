package easy.question155;

import java.util.Stack;

/**
 * Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStackWIthOneStack {

    Integer min = Integer.MAX_VALUE;
    Stack<Integer> stack = null;

    /** initialize your data structure here. */
    public MinStackWIthOneStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x<=min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop().equals(min)) {
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStackWIthOneStack ms = new MinStackWIthOneStack();
        ms.push(512);
        ms.push(-1024);
        ms.push(-1024);
        ms.push(512);
        ms.pop();
        int a=ms.getMin();
        ms.pop();
        int b = ms.getMin();
        ms.pop();
        int c = ms.getMin();
    }
}
