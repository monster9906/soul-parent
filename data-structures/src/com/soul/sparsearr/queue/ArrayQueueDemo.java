package com.soul.sparsearr.queue;


import java.util.Scanner;

/**
 * @author 符浩灵
 * @date 2020/7/6 21:38
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 测试队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //用户的输入
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中获取数据");
            System.out.println("p(peek)：显示队列头部信息");
            System.out.println("e(exit)：对出队列");
            key = scanner.next().charAt(0); //获取键盘的输入
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入需要添加的数据");
                    int i = scanner.nextInt();
                    arrayQueue.addQueue(i);
                    break;
                case 'g':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.printf("获取的数据为：%d\n",queue);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'p':
                    int peek = arrayQueue.peek();
                    System.out.printf("队列的头部信息为：%d\n",peek);
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    System.out.println("程序退出！！！");
                    break;
            }

        }
    }
}

/**
 * 数组模拟队列
 */
class ArrayQueue{
    private int maxSize;  // 数组最大容量
    private int front; // 队列首
    private int rear; // 队列尾
    private int[] arr; //存放数据数组

    /**
     * 创建队列的构造器,并对队列的头和尾进行复制
     * @param arrSize
     */
    public ArrayQueue(int arrSize){
        maxSize = arrSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull(){
        return rear == maxSize-1;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return  front == rear;
    }

    /**
     * 向队列中添加数据
     * @param data
     */
    public void addQueue(int data){
        // 判断是否已满
        if(isFull()){
            System.out.println("当前队列已满，请稍后重试");
            return;
        }
        rear ++; //尾部指针后移
        arr[rear] = data;
    }

    /**
     * 从队列中获取数据
     * @return
     */
    public int getQueue(){
        //判断是否为空
        if(isEmpty()){
            throw new RuntimeException("数组为空，无法获取数据");
        }
        front++;//头部指针后移
        int i = arr[front];
        arr[front] = 0;
        return i;
    }

    /**
     * 遍历输出数组
     */
    public void showQueue(){
        if (isEmpty()) {
            System.out.println("队列为空，暂时不支持遍历输出");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]==%d\n",i,arr[i]);
        }
    }

    /**
     * 查看队列的头部信息
     * @return
     */
    public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，暂时不支持遍历输出");
        }
        return arr[front+1];
    }
}


