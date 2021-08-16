package com.soul.list;

import java.util.Stack;

/**
 * @author 符浩灵
 * @date 2020/7/10 17:57
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1,"贾宝玉","混世魔王");
        HeroNode heroNode3 = new HeroNode(4,"薛宝钗","宝钗");
        HeroNode heroNode2 = new HeroNode(3,"王熙凤","凤辣子");
        HeroNode heroNode1 = new HeroNode(2,"林黛玉","林妹妹");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(heroNode);
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
//        singleLinkedList.addByOrder(heroNode);
//        singleLinkedList.addByOrder(heroNode1);
//        singleLinkedList.addByOrder(heroNode2);
//        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.list();

//        HeroNode newHeroNode = new HeroNode(2,"林黛玉","天上掉下个林妹妹");
//        singleLinkedList.update(newHeroNode);
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        reservPrint(singleLinkedList.getHead());


//        reversetList(singleLinkedList.getHead());
//        singleLinkedList.list();

    }

    // 反转单链表
    public static void reversetList(HeroNode head){
        if(head.next == null || head.next.next == null){ // 为空或是只有一个节点
            return;
        }

        // 定义辅助变量
        HeroNode cur = head.next; // 当前节点
        HeroNode next = null; // 指向当前节点的下一个节点
        HeroNode reserveHead = new HeroNode(0,"","");

        //遍历
        while (cur != null){
            next = cur.next; //保存当前节点的下一个节点
            cur.next = reserveHead.next; // 将当前节点的指向新链表的最前端
            reserveHead.next = cur;
            cur = next;
        }
        //原来的head指向新的head
        head.next = reserveHead.next;
    }

    // 从尾到头打印单链表，在不改变链表的结构情况下
    public static void reservPrint(HeroNode head){
        if(head.next == null){
            return;// 链表为空
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        // 循环往栈中插入数据
        while (cur != null){
            stack.push(cur);
            cur = cur.next; // 指针后移
        }
        // 打印结果
        while (stack.size() >0 ){
            System.out.println(stack.pop());
        }
    }

}

class SingleLinkedList{
    // 定义head信息
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead(){
        return head;
    }

    // 向链表中添加数据
    public void add(HeroNode heroNode){
        // head节点不能动，定义临时变量来保存
        HeroNode temp = head;
        while (true){
            // 表示到最后一个节点了
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }

        // 退出循环节点已经指到最后
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head; // 投不用动
        boolean flag= false;// 标识添加的编号是否存在
        while (true) {
            if(temp.next == null){
                break;
            }else if(temp.next.no>heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;// 指针后移
        }
        if(flag){
            System.out.printf("当前添加的编号%d已经存在,不能重复加入\n",heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;

        }
    }

    /**
     * 修改节点
     * @param heroNode
     */
    public void update(HeroNode heroNode){
        if(head.next == null){
            System.out.println("当前节点为空~~~");
            return;
        }
        HeroNode temp= head.next;
        boolean flag = false; //是否找到修改的节点
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == heroNode.no ){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }else {
            System.out.printf("编号为：%d的人物尚未找到~~~",heroNode.no);
        }
    }

    /**
     * 删除节点
     */
    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next == null){ //节点到达最后
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else{
            System.out.printf("%d编号的人物不存在！",no);
        }
    }

    // 输出链表
    public void list(){
        if(head.next == null){
            System.out.println("当前链表为空");
            return;
        }
        // 头节点不能动
        HeroNode temp = head.next;
        while (true){
            // 判断是否到了最后一个节点
            if(temp == null){
                break;
            }
            System.out.println(temp);
            // 使指针后移
            temp = temp.next;
        }
        }
}

class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
