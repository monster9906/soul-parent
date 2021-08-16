package com.soul.container;

import java.util.*;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/8-14:24
 */
public class InterfaceVsIterator {
    public static void display(Iterator<StringAddress> iterator){
        while (iterator.hasNext()){
            StringAddress next = iterator.next();
            System.out.print(next.toString());
        }
        System.out.println();
    }

    public static void display(Collection<StringAddress> collection){
        for (StringAddress stringAddress : collection) {
            System.out.print(stringAddress.toString());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringAddress stringAddress = new StringAddress("测试");
        StringAddress stringAddress1 = new StringAddress("用户");
        StringAddress stringAddress2 = new StringAddress("玩家");
        StringAddress stringAddress3 = new StringAddress("Java");

        List<StringAddress> addressList = Arrays.asList(stringAddress,stringAddress1,stringAddress2,stringAddress3);
        Set<StringAddress> addressSet = new HashSet<>(addressList);
        Map<String,StringAddress> addressMap = new LinkedHashMap<>();
        String[] names = ("文理学院,机电学院,计电学院,信息学院").split(",");
        for (int i = 0; i < names.length; i++) {
            addressMap.put(names[i],addressList.get(i));
        }

        display(addressList);
        display(addressSet);
        display(addressList.iterator());
        display(addressSet.iterator());
        System.out.println(addressMap);
        System.out.println(addressMap.keySet());
        display(addressMap.values());
        display(addressMap.values().iterator());
    }
}
