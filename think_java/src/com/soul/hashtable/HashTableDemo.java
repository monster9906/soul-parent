package com.soul.hashtable;

import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/30-16:58
 */
public class HashTableDemo {
    public static void main(String[] args) {
        Employee employee = new Employee(1,"尹老师");
        Employee employee1 = new Employee(2, "憨批");
        Employee employee2 = new Employee(3,"LSP");

        HashTab hashTab = new HashTab(3);
        hashTab.add(employee);
        hashTab.add(employee1);
        hashTab.add(employee2);

        hashTab.list();

    }
}
class HashTab{
    private EmployeeLinkedList[] employeeLinkedArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        employeeLinkedArray = new EmployeeLinkedList[size];
        for (int i = 0; i < size; i++) {
            employeeLinkedArray[i] = new EmployeeLinkedList();
        }
    }

    public void add(Employee employee){
        int index = hashFun(employee.id);
        employeeLinkedArray[index].add(employee);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            employeeLinkedArray[i].list();
        }
    }

    // 散列算法
    private int hashFun(int id){
        return id % size;
    }

}

class Employee {
    public int id;
    public String name;
    public Employee next;// 指向下一个节点

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmployeeLinkedList{
    private Employee head; //空的头节点

    public void add(Employee employee){ // 添加到链表的最结尾
        if(head == null){ // 第一个为空的时候，直接添加到第一个上
            head = employee;
            return;
        }
        Employee currentEmp = head;
        while (true){
            // 找到链表的最结尾
            if(currentEmp.next == null){
                break;
            }
            //  后移
            currentEmp = currentEmp.next;
        }
        currentEmp.next = employee;
    }

    public void list(){
        if(head == null){ // 链表为空
            System.out.println("当前链表为空");
        }
        Employee currentEmp = head;
        while (true){
            System.out.printf("id=>%d name=>%s \t",currentEmp.id,currentEmp.name);
            if(currentEmp.next == null){
                break;
            }
            currentEmp = currentEmp.next;
        }
        System.out.println();
    }
}