package second;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 */

import java.util.LinkedList;

public class Problem155 {

    public static void main(String[] args) {
        Solution155 solution = new Solution155();
        Solution155.MinStack obj = new Solution155.MinStack();
        obj.push(2);
        obj.push(5);
        obj.pop();
        int param3 = obj.top();
        int param4 = obj.getMin();
        System.out.println(obj.getMin());
        System.out.println(param3);
        System.out.println(param4);
    }
}

class Solution155 {
    public static class MinStack {

        LinkedList<int[]> stack;

        public MinStack() {
            stack = new LinkedList<>();
        }

        public void push(int val) {
            int[] top = stack.isEmpty() ? new int[]{val, val} : stack.getLast();

            int minVal = top[1];
            if (minVal > val) {
                minVal = val;
            }

            stack.add(new int[]{val, minVal});
        }

        public void pop() {
            stack.removeLast();
        }

        public int top() {
            return stack.isEmpty() ? - 1 : stack.getLast()[0];
        }

        public int getMin() {
            return stack.isEmpty() ? -1 : stack.getLast()[1];
        }
    }
}
