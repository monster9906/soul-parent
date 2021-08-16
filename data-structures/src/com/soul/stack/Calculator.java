package com.soul.stack;

/**
 * @author LingCoder
 * @Description: 栈模拟计算器 如 输入 3+2*6-5 返回：10
 * @Date 2020/8/20-9:09
 */
public class Calculator {
  public static void main(String[] args) {
      String exp = "300+2*5-5";

    // 准备数栈和符号栈
      ArrayStack2 numStack = new ArrayStack2(10);
      ArrayStack2 oprStack = new ArrayStack2(10);

      // 定义扫描索引
      int index = 0;
      // 定义参数
      int num1 = 0;
      int num2 = 0;
      int res = 0;
      int opr = 0;
      char ch = ' '; // 存放扫描到的符号
      String keepNum = ""; // 用于拼接判断是否数字后面还有数字

      // 开始扫描表达式
      while (true){
          ch = exp.substring(index,index+1).charAt(0);
          // 判读获取的ch是什么类型 做对应的处理
          if (oprStack.isOpr(ch)) { // 是操作符
              // 如歌当前符号栈为空 直接压入，反之
              if(!oprStack.isEmpty()){
                    // 当前符号栈存在符号，判断优先级，如果传入符号的优先级小于或等于符号栈里面的优先级，则从数栈去pop两个数，
                   // 在把符号栈中的符号pop出来，进行运算 得到数字结果压入数栈，再将当前的符号入符号栈
                  if(oprStack.priority(ch) <= oprStack.priority(oprStack.peek())){
                      // 从数栈获取两个数组
                      num1 = numStack.pop();
                      num2 = numStack.pop();
                      // 从符号栈获取符号
                      opr = oprStack.pop();
                      // 获取结果
                      res = numStack.cal(num1,num2,opr);
                      // 数字结果入数栈，符号入符号栈
                      numStack.push(res);
                      oprStack.push(ch);
                  }else {
                      // 当前符号的优先级大于符号栈中的优先级 直接压入
                      oprStack.push(ch);
                  }
              }else {
                  oprStack.push(ch);
              }

          }else {
              // 是数字 换算asc码
//              numStack.push(ch-48);
              // 判断下一个符号是数字还是运算符 是运算符直接入数栈
              keepNum += ch;
              // 如果当前符号已经是最后一位，直接入数栈
              if(index == exp.length()-1){
                  numStack.push(Integer.parseInt(keepNum));
              }else{
                  if(oprStack.isOpr(exp.substring(index+1,index+2).charAt(0))){
                      numStack.push(Integer.parseInt(keepNum));
                      //keepNum重置过
                      keepNum = "";
                  }
              }



          }

          // index ++ ,并判断是否到表达式的结尾
          index ++;
          if(index >=exp.length()){
              break;
          }
      }

      // 扫描表达式结束，顺序的从数栈和符号栈压出对应的数据并运算
      while (true){
          // 符号栈中为空的时候 数栈只剩下最后一个数子 这个就是最终的结果
          if(oprStack.isEmpty()){
              break;
          }
          num1 = numStack.pop();
          num2 = numStack.pop();
          // 从符号栈获取符号
          opr = oprStack.pop();
          // 获取结果
          res = numStack.cal(num1,num2,opr);
          // 数字结果入数栈，符号入符号栈
          numStack.push(res);
      }
    System.out.printf("表达式：%s=%d\n",exp,numStack.pop());
  }
}


class ArrayStack2{
    private Integer maxSize; // 栈的最大数
    private int[] stack;// 数组 模拟栈
    private int top = -1; // 栈顶 初始值为-1  到栈的最低

    public ArrayStack2(Integer maxSize){
        this.maxSize =maxSize;
        stack = new int[maxSize];
    }

    /**
     * 栈是否已经满了
     * @return
     */
    public boolean isFull(){
        return top == (maxSize-1);
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈操作
     * @param value
     */
    public void push(int value){
        if (isFull()) { // 栈满
            System.out.println("栈已满，请检查！");
            return;
        }
        top++; // 指针后移
        stack[top] = value;
    }

    /**
     * @author LingCoder
     * @date 2020/8/20 11:19
     * @description:  返回栈顶的信息
     * @return int
     */
    public int peek(){
        return stack[top];
    }

    /**
     * 出栈
     * @return
     */
    public int pop(){
        if (isEmpty()) {
            throw  new RuntimeException("栈为空！");
        }
        int value = stack[top];
        top--;// 指针下移
        return value;
    }

    /**
     * 遍历输出栈（从顶部开始）
     */
    public void list(){
        if (isEmpty()) {
            System.out.println("栈空！");
            return;
        }
        for (int i = top;i>=0;i--){
            System.out.printf("stack[%d]:value=%d\n",i,stack[i]);
        }
    }

    /**
     *
     * @author LingCoder
     * @date 2020/8/20 9:14
     * @description: 判断符号优先级，数字越大 优先级越高
     * @return int
     */
    public int priority(int opr){
        if(opr == '*' || opr == '/'){
            return 1;
        }else if(opr == '+' || opr == '-'){
            return 0;
        }else {
            return -1;
        }
    }

    /**
     *
     * @author LingCoder
     * @date 2020/8/20 9:19
     * @description: 判断是否是操作符
     * @return boolean
     */
    public boolean isOpr(char opr){
        return opr == '+' || opr == '-' || opr == '*' ||opr == '/';
    }

    /**
     *
     * @author LingCoder
     * @date 2020/8/20 9:20
     * @description: 计算方法
     * @return int
     */
    public int cal(int num1 ,int num2,int opr){
        int res = 0;
        switch (opr) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                // 顺序问题
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}