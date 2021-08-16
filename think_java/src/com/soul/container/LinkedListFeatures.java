package com.soul.container;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/6-15:06
 */
public class LinkedListFeatures {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("尹老师", "文理学院","机电职院","计电学院","410"));

        System.out.println(linkedList);

        System.out.println("linkedList getFirst(）： " + linkedList.getFirst());
        System.out.println("linkedList element(): " +linkedList.element());

        System.out.println("peek(): " +linkedList.peek());
        System.out.println("remove(): "+linkedList.remove());
        System.out.println("removeFirst:"+linkedList.removeFirst());

        System.out.println("poll():" +linkedList.poll());

        System.out.println(linkedList);

        linkedList.addFirst(new String("头部添加"));
        System.out.println("addFirst():"+linkedList);

        linkedList.offer("头部添加2");
        System.out.println("offer()"+linkedList);

        linkedList.add("添加数据");
        System.out.println("add():"+linkedList);

        linkedList.addLast("尾部添加");
        System.out.println("addLast():"+linkedList);

        System.out.println("removeLast():"+linkedList.removeLast());

    }
}
