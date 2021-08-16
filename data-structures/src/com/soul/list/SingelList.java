package com.soul.list;

/**
 * @author LingCoder
 * @date 2020/7/27 17:01
 * 单向链表问题 约瑟夫问题
 */
public class SingelList {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1, 2, 5);

    }

}

// 单向环形链表
class CircleSingleLinkedList{
    // 初始化第一个节点
    private Boy first = new Boy(0);

    // 构建环形链表 nums 环形链表的节点个数
    public void addBoy(int nums){
        if(nums <1){
            System.out.println("节点个数不够，无法成环");
            return;
        }
        Boy cur = null;// 辅助指针 指向当前节点

        for (int i = 1; i <= nums; i++) {
            // 根据编号 创建对应的节点
            Boy boy = new Boy(i);
            if( i == 1){ // 表示是第一个节点
                first = boy;
                first.setNext(boy); // 形成环形结构
                cur = first;
            }else {
                cur.setNext(boy);
                boy.setNext(first);
                cur = boy; // 指针后移
            }
        }
    }

    // 遍历输出单向环形链表
    public void showBoy(){
        if(first == null){
            System.out.println("链表为空");
        }
        Boy cur = first;
        while (true){
            System.out.printf("当前编号为：%d\n",cur.getNo());
            if(cur.getNext() == first){
                // 遍历完成
                break;
            }

            cur = cur.getNext(); // 指针后移
        }

    }

    /**
     * 计算出圈顺序
     * @param start 从第几个开始数
     * @param countNum 一次数几个
     * @param nums 链表的数量
     */
    public void countBoy(int start ,int countNum ,int nums){
        if(first == null || start<1 || start>nums){
            System.out.println("参数操作，请重新输入");
            return;
        }
        // 定义辅助变量，来辅助出圈操作
        Boy helper = first;
        while (true){
            if(helper.getNext() == first){ // 指向最后一个节点
                break;
            }
            helper = helper.getNext();
        }

        // 出圈之前，让辅助变量移动看k-1次
        for (int j = 0; j < start - 1; j++) {
            first =first.getNext();
            helper = helper.getNext();
        }

        // 出圈操作
        while (true){
            if(helper == first){ // 只有一个节点
                break;
            }

            // first和helper同时移动
            for (int j = 0; j < countNum-1; j++) {
                first =first.getNext();
                helper = helper.getNext();
            }

            System.out.printf("出圈人的编号%d\n",first.getNo());

            // 将出现的节点从链表去除

            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后出圈人的编号%d\n",first.getNo());

    }
}


// 创建节点
class Boy {
    private int no;
    private Boy next; // 指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
