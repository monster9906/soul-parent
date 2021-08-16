    package com.soul.algorithm;


    /**
     * @author LingCoder
     * @Description:
     * @Date 2020/9/28-12:37
     */
    public class InvertedSingLinkedListDemo {
        public static void main(String[] args) {
            SingleLinkedList linkedList = new SingleLinkedList();
            Node node1 = new Node("测试数据1");
            Node node2 = new Node("测试数据2");
            Node node3 = new Node("测试数据3");
            Node node4 = new Node("测试数据4");
            linkedList.add(node1);
            linkedList.add(node2);
            linkedList.add(node3);
            linkedList.add(node4);

            linkedList.list();
            System.out.println("递归反转之后.................");
            Node node = reverseList(linkedList.getHead());
            show(node);
        }

        public static void show(Node node) {
            if (node == null || node.next == null) {
                return;
            }
            Node next = node;
            while (next != null && next.next != null) {
                System.out.println(next);
                next = next.next;
            }
        }

        public static Node reverseList(Node node) {
            if (node == null || node.getNext() == null) {
                // 只有一个节点，直接返回
                return node;
            }
            // 头节点 头节点置为末尾
            // 直接遍历到节点的末尾
            Node revertHead = reverseList(node.getNext());
            node.next.next = node;
            node.next = null;
            return revertHead;
        }

    }

    class SingleLinkedList {
        private Node head = new Node(""); // 定义空的头节点

        /**
         * @return void
         * @author LingCoder
         * @date 2020/9/28 13:22
         * @description: 向链表中添加节点
         */
        public void add(Node data) {
            // 头节点不能动，用临时变量来移动
            Node temp = head;
            while (true) {
                if (temp.getNext() == null) { // 到最后一个节点
                    break;
                }
                temp = temp.getNext();
            }
            // 循环结束，保证当前节点已经指向最后
            temp.setNext(data);
        }

        public Node getHead() {
            return head;
        }

        /**
         * @return void
         * @author LingCoder
         * @date 2020/9/28 12:45
         * @description: 遍历输出单链表
         */
        public void list() {
            if (head.getNext() == null) {
                System.out.println("当前链表为空");
                return;
            }
            // 头节点不能动下一个节点,指向
            Node temp = head.getNext();
            while (true) {
                // 判断是否到了最后一个节点
                if (temp == null) {
                    break;
                }
                System.out.println(temp);
                // 使指针后移
                temp = temp.getNext();
            }
        }

    }

    /**
     * @author LingCoder
     * @date 2020/9/28 12:41
     * @description: 结构
     * @return * @return: null
     */
    class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }