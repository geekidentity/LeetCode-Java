package com.geekidentity.leetcode.offer.stack;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 */
public class MinStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();


    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            int min = minStack.peek();
            if (x < min) {
                min = x;
            }
            minStack.push(min);
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
            stack.pop();
        }

    }

    public int top() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        System.out.println(stack.top());
    }
}
