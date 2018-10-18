package core;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonitorAgent {
    public static void main(String[] args)
    {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Thread thread = new Thread();
        scheduler.scheduleAtFixedRate(thread, 0L, 5L, TimeUnit.MINUTES);
    }
}
