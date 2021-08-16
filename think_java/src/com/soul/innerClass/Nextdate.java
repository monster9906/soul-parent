package com.soul.innerClass;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author LingCoder
 * @Description:
 * @Date 2020/11/4-15:40
 */
public class Nextdate {

    public static String getNextDate(String dateStr) throws ParseException {
        dateStr = dateStr.replace("年","-");
        dateStr = dateStr.replace("月","-");
        dateStr = dateStr.replace("日","-");
        String[] dateArray = dateStr.split("-");

        // 年
        int year = Integer.parseInt(dateArray[0]);
        if((year<1||year>2050)){
            return "年份有误";
        }

        // 月
        int month = Integer.parseInt(dateArray[1]);
        if(month>12||month<1){
            return "月份有误";
        }

        // 日
        int day = Integer.parseInt(dateArray[2]);
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            if(day>31||day<1){
                return "当前天有误";
            }
        }
        if(month==4||month==6||month==9||month==11){
            if(day>30||day<1){
                return "当前天有误";
            }
        }

        // 处理2月份
        if((year%4==0 && year%100 != 0)||(year%400 == 0)){ // 润年
            if(month == 2){
                if(day >29){
                    return "当前天有误";
                }else {
                    if(day == 29){
                        day = 1;
                    }else {
                        day++;
                    }
                }
            }
        }else {
            if(month == 2){
                if(day > 28){
                    return "当前天有误";
                }else {
                    if(day == 28){
                        day =1 ;
                    }else {
                        day ++;
                    }
                }
            }
        }

        // 根据月份处理对应的日期
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if(day == 31 ){
                    month++;
                    day = 1;
                }else {
                    day ++;
                }
                return year+"年"+month+"月"+day+"日";

            case 2:
                if(day == 1){
                    month++;
                }
                return year+"年"+month+"月"+day+"日";
            case 4:
            case 6:
            case 9:
            case 11:
                if(day == 30){
                    month++;
                    day = 1;
                }else {
                    day++;
                }
                return year+"年"+month+"月"+day+"日";
            case 12:
                if(day ==31){
                    year++;
                    month =1;
                    day=1;
                }else {
                    day++;
                }
                return year+"年"+month+"月"+day+"日";
        }
        return "";
    }

    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期：格式（yyyy年MM月dd日）\n退出按 (n/N), 否则继续: ");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String dateStr = scanner.nextLine();
            if("n".equalsIgnoreCase(dateStr)){
                break;
            }
            String nextDate = getNextDate(dateStr);
            System.out.println(nextDate);
            System.out.println("按(n/N),退出，否则继续");
        }
    }
}
