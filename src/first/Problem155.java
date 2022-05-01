package first;
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


  Example 1:

    Input
    ["first.MinStack","push","push","push","getMin","pop","top","getMin"]
    [[],[-2],[0],[-3],[],[],[],[]]

    Output
    [null,null,null,null,-3,null,0,-2]

    Explanation
    first.MinStack minStack = new first.MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin(); // return -3
    minStack.pop();
    minStack.top();    // return 0
    minStack.getMin(); // return -2
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem155 {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(6);
        obj.pop();
        System.out.println(obj.top());
        obj.push(2);
        obj.push(5);
        obj.push(3);
        System.out.println(obj.getMin());
    }
}


class MinStack {
    private List<Integer> elements;

    public MinStack() {
        elements = new ArrayList<>();
    }

    public void push(int x) {
        elements.add(0, x);
    }

    public void pop() {
        elements.remove(0);
    }

    public int top() {
        return elements.get(0);
    }

    public int getMin() {
        return Collections.min(elements);
    }
}


