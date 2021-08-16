package com.soul.innerClass;

import java.time.Duration;
import java.time.Instant;

/**
 * @author LingCoder
 * @date 2020/7/27 15:52
 */
public abstract class Event {
    private Instant eventTime;
    protected final Duration delayTime;

    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
    }

    public void start() { // Allows restarting
        eventTime = Instant.now().plus(delayTime);
    }
    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }
    public abstract void action();

}
