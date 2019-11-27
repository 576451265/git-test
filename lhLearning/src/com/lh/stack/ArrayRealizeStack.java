package com.lh.stack;

/**
 * @Description: 数组实现栈1
 * @author LuoH
 * @date 2019/11/12
 */
public class ArrayRealizeStack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public ArrayRealizeStack(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }
    public void push(long j){
        stackArray[++top] = j;
    }
    public long pop(){
        return stackArray[top--];
    }
    public long peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull(){
        return (top == maxSize - 1);
    }
    public static void main(String[] args) {
        ArrayRealizeStack stack = new ArrayRealizeStack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()){
            long value = stack.pop();
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println("");
    }
}
