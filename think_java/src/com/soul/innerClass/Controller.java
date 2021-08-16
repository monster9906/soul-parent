package com.soul.innerClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LingCoder
 * @date 2020/7/27 15:58
 */
public class Controller {
    private List<Event> events = new ArrayList<>();
    public void addEvent(Event event){
        events.add(event);
    }

    public void run (){
        while (events.size()>0){
            for (Event event : events) {
                if(event.ready()){
                    System.out.println(event);
                    event.action();
                    events.remove(event);
                }
            }
        }
    }
}
