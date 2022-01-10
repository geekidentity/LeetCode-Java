package com.geekidentity.leetcode.offerII;

import java.util.Stack;

/**
 * 模拟
 * 剑指 Offer 31. 栈的压入、弹出序列
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 *
 * 1. 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
 * 2. 如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
 * 3. 如果所有数字都压入栈，还没有下一个弹出的数字（stack不为空），则该序列不是一个弹出序列。
 */
public class Offer31ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
