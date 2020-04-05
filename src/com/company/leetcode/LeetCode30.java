package com.company.leetcode;

import java.util.Stack;

public class LeetCode30 {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-10);
    minStack.push(14);
    System.out.println(minStack.min());
    System.out.println(minStack.min());
    minStack.push(-20);
    System.out.println(minStack.min());
    System.out.println(minStack.min());
    System.out.println(minStack.top());
    System.out.println(minStack.min());
    minStack.pop();
    minStack.push(10);
    minStack.push(-7);
    System.out.println(minStack.min());
    minStack.push(-20);
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.min());
    minStack.pop();
  }

  static class MinStack {

    private Stack<Integer> mStack;
    private Stack<Integer> mMinStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
      mStack = new Stack<>();
      mMinStack = new Stack<>();
    }

    public void push(int x) {
      if (mStack.size() > 0) {
        if (x < min()) {
          mMinStack.push(x);
        } else {
          mMinStack.push(min());
        }
      } else {
        mMinStack.push(x);
      }
      mStack.push(x);
    }

    public void pop() {
      mStack.pop();
      mMinStack.pop();
    }

    public int top() {
      return mStack.peek();
    }

    public int min() {
      return mMinStack.peek();
    }
  }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
