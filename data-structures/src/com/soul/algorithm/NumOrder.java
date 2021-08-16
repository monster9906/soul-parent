package com.soul.algorithm;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.*;

/**
 * @author LingCoder
 * @Description:给定n(1<=n<=1000)个整数(<=1000的正整数),
 * 请统计出每个整数出现的次数,按出现次数从多到少的顺序输出.
 * @Date 2020/9/15-16:33
 */
public class NumOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数N:");
        int n = scanner.nextInt();
        if(n<=1 && 1000>=n ){
            System.out.println("请输入大于1小于1000的整数");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= scanner.nextInt();
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            Integer num = map.get(i);
            map.put(i,num==null?1:num+1);
        }

        // 根据map的value进行排序
        map = sortByValue(map);

        // 遍历循环输出结果
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.printf("%d  %d\n",entry.getKey(),entry.getValue());
        }

    }


    /**
     * @author LingCoder
     * @date 2020/9/15 21:01
     * @description: 将map按value进行排序
     * @return java.util.Map<java.lang.Integer,java.lang.Integer>
     */
    private static Map<Integer, Integer> sortByValue(Map<Integer,Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<Map.Entry<Integer, Integer>>(
                map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                        .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        Iterator<Map.Entry<Integer, Integer>> iter = entryList.iterator();
        Map.Entry<Integer, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }


}
