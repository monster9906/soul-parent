package com.soul.think;

import java.util.concurrent.TimeUnit;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/12/9-23:15
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1,"詹姆斯");
        HeroNode node1 = new HeroNode(2, "欧文");
        HeroNode node2 = new HeroNode(3, "艾弗森");
        HeroNode node3 = new HeroNode(4, "科比");
        HeroNode node4 = new HeroNode(5, "奥尼尔");

        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node4);
        node2.setRight(node3);
        binaryTree.setRoot(root);

       /* System.out.println("前序输出");
        binaryTree.proOrder();
        System.out.println("中序输出");
        binaryTree.midOrder();
        System.out.println("后序输出");
        binaryTree.postOrder();

        System.out.println("前序查找");
        HeroNode node = binaryTree.proOrderSearch(5); // 4
        System.out.println(node);

        System.out.println("中序查找");
        HeroNode node5 = binaryTree.midOrderSearch(5); // 3
        System.out.println(node5);

        System.out.println("后序查找");
        HeroNode node6 = binaryTree.postOrderSearch(5); // 2
        System.out.println(node6);*/

        System.out.println("前序输出");
        binaryTree.proOrder();
        binaryTree.delNode(3);
        System.out.println("前序输出");
        binaryTree.proOrder();

    }
}
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no) {
                root = null;
                return;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("tree is empty");
        }
    }

    // 前序输出
    public void proOrder(){
        if(this.root != null){
            this.root.proOrder();
        }else {
            System.out.println("tree is empty");
        }
    }

    // 中序输出
    public void midOrder(){
        if(this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("tree is empty");
        }
    }

    // 后序输出
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("tree is empty");
        }
    }

    public HeroNode proOrderSearch(int no){
        if(this.root != null){
            return this.root.proOrderSearch(no);
        }else {
            System.out.println("tree is empty");
        }
        return null;
    }

    public HeroNode midOrderSearch(int no){
        if (this.root != null) {
            return this.root.midOrderSearch(no);
        }else {
            System.out.println("tree is empty");
        }
        return null;
    }

    public HeroNode postOrderSearch(int no){
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        }else {
            System.out.println("tree is empty");
        }
        return null;
    }

}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 删除节点
    public void delNode(int no){
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }

        if(this.left != null){
            this.left.delNode(no);
        }

        if(this.right != null){
            this.right.delNode(no);
        }
    }


    // 前序输出
    public void proOrder(){
        // 先遍历父节点
        System.out.println(this);
        // 再遍历左节点
        if(this.left != null){
            this.left.proOrder();
        }
        // 遍历右节点
        if(this.right != null){
            this.right.proOrder();
        }
    }

    // 中序输出
    public void midOrder(){
        // 先遍历左节点
        if(this.left != null){
            this.left.midOrder();
        }
        // 输出父节点
        System.out.println(this);

        // 输出右节点
        if(this.right != null){
            this.right.midOrder();
        }
    }

    // 后序输出
    public void postOrder(){
        // 先遍历左节点
        if(this.left != null){
            this.left.postOrder();
        }
        // 输出右节点
        if(this.right != null){
            this.right.postOrder();
        }
        // 输出父节点
        System.out.println(this);
    }

    public HeroNode proOrderSearch(int no){
        System.out.println("前序查找....");
        if(this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.proOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }


        if(this.right != null){
            resNode = this.right.proOrderSearch(no);
        }


        return resNode;
    }

    public HeroNode midOrderSearch(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.midOrderSearch(no);
        }

        if(resNode != null){
            return resNode;
        }
        System.out.println("中序查找....");
        if(this.no == no){
           return this;
        }

        if(this.right != null){
            resNode = this.right.midOrderSearch(no);
        }


        return resNode;
    }

    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if(this.left != null){
            resNode = this.left.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.postOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        System.out.println("后序查找....");

        if(this.no == no){
            return this;
        }

        return resNode;
    }
}