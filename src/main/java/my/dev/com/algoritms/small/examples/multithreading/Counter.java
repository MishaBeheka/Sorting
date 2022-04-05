package my.dev.com.algoritms.small.examples.multithreading;

public class Counter {
    private Long count = 0L;


    synchronized public void increment() {
        count++;
    }

    public Long counter() {
        return count;
    }
}
