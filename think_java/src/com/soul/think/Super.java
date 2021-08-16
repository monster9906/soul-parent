package com.soul.think;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/10/7-20:41
 */
public class Super {
    public int fied = 0;
    public int getFied(){
        return fied;
    }
}

class Sub extends Super{
    public int fied = 1;
    public int getFied(){
        return fied;
    }

    public int getSuperFied(){
        return super.fied;
    }
}


class FieldAccess{
    public static void main(String[] args) {
        Super aSuper = new Sub();
        System.out.println("super~fied"+aSuper.fied+"  super getFile:"+aSuper.getFied());
        Sub sub = new Sub();
        System.out.println("super~fied"+sub.fied+"super getFile:"+sub.getFied()+" supeer fied "+sub.getSuperFied());
    }
}
