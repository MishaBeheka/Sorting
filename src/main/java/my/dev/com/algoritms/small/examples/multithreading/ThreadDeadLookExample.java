package my.dev.com.algoritms.small.examples.multithreading;

import java.util.concurrent.TimeUnit;

public class ThreadDeadLookExample {


    public static void main(String[] args) throws InterruptedException {
        threadsDeadLook();
    }

    public static void threadsDeadLook() throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread t1 = new Thread(() -> {
            synchronized (counter1) {
                sleepSeconds(1);
                counter2.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (counter2) {
                counter1.increment();
            }
        });

        Thread t3 = new Thread(() -> {
            while (true) {
                System.out.println("T1 state " + t1.getState());
                System.out.println("T2 state " + t2.getState());
            }
        });

        t3.start();


        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void sleepSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
