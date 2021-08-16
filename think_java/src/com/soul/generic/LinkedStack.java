package com.soul.generic;

/**
 * @author Rich_fu
 * @date 2021/3/13
 */
public class LinkedStack <T>{

        private static class Node<U>{
        U item;
        Node<U> next;

        Node(){item = null;next = null;}

        Node(U item,Node<U> next){
            this.item = item;
            this.next = next;
        }

        boolean end() {return item == null && next == null;}
    }

    private Node<T> top = new Node<>();

    public void push(T item){
        top = new Node<>(item,top);
    }

    public T pop (){
        T item = top.item;
        if(!top.end()){
            top = top.next;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        for (String s : "phasers on stun !".split(" ")) {
            linkedStack.push(s);
        }

        String s ;
        while ((s = linkedStack.pop()) != null){
            System.out.println(s);
        }
    }
}
