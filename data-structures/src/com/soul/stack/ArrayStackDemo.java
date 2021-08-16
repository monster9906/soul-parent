package com.soul.stack;

import java.util.Scanner;

/**
 * @author LingCoder
 * @date 2020/8/10 15:35
 *  数组模拟入栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);

        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show:显示所有的栈");
            System.out.println("exit:退出程序操作");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");

            key = scanner.next();

            switch (key) {
                case "show":
                    arrayStack.list();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int val = scanner.nextInt();
                    arrayStack.push(val);
                    break;
                case "pop":
                    try {
                        System.out.println("出栈数据："+arrayStack.pop());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        System.out.println("stack program exit ~~~~");
    }

}

class ArrayStack{
    private Integer maxSize; // 栈的最大数
    private int[] stack;// 数组 模拟栈
    private int top = -1; // 栈顶 初始值为-1  到栈的最低

    public ArrayStack(Integer maxSize){
        this.maxSize =maxSize;
        stack = new int[maxSize];
    }

    /**
     * 栈是否已经满了
     * @return
     */
    public boolean isFull(){
        return top == (maxSize-1);
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈操作
     * @param value
     */
    public void push(int value){
        if (isFull()) { // 栈满
            System.out.println("栈已满，请检查！");
            return;
        }
        top++; // 指针后移
        stack[top] = value;
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (isEmpty()) {
            throw  new RuntimeException("栈为空！");
        }
        int value = stack[top];
        top--;// 指针下移
        return value;
    }

    /**
     * 遍历输出栈（从顶部开始）
     */
    public void list(){
        if (isEmpty()) {
            System.out.println("栈空！");
            return;
        }
        for (int i = top;i>=0;i--){
            System.out.printf("stack[%d]:value=%d\n",i,stack[i]);
        }
    }
}
