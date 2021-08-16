package com.soul.container;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/8-13:01
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i+10));
        }
        PrintQ(queue);

        Queue<Character> characterQueue = new LinkedList<>();
        for (char c : "hunanwenlixueyuan".toCharArray()) {
            characterQueue.offer(c);
        }
        PrintQ(characterQueue);
    }

    public static void PrintQ(Queue queue){
        while (queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

}
