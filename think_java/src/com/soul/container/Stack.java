package com.soul.container;

import java.util.LinkedList;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/6-21:15
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void push(T v){
        storage.addFirst(v);
    }

    public T peek(){
        return storage.getFirst();
    }

    public T pop(){
        return storage.removeFirst();
    }

    public boolean empty(){
        return storage.isEmpty();
    }

    public String toString(){
        return storage.toString();
    }

}
