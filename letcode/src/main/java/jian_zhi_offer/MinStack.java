package jian_zhi_offer;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * min() 返回最小的元素，push（x） 插入新数据，pop（） 弹出栈尾数据
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class MinStack {
    private final Stack<Integer> dataStack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }


    public void push(int x) {
        // 最小栈保存最小的数据，新增的数据比最小值大，则重复推入最小值
        if (dataStack.isEmpty() || minStack.peek() > x) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
        dataStack.push(x);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
