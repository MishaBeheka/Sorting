package my.dev.com.algoritms.small.examples.multithreading;

public class MultithreadingStatesExample {
    private static final Object SYNCHRO_STATE = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(MultithreadingStatesExample::run);
        System.out.println(thread1.getState()); //NEW
        thread1.start();
        System.out.println(thread1.getState());//RUNNABLE
        Thread.sleep(1000);
        System.out.println(thread1.getState());//TIMED_WAITING

        Thread thread2 = new Thread(MultithreadingStatesExample::run);
        thread2.start();
        Thread.sleep(1000);
        System.out.println(thread2.getState());//BLOCKED
        Thread.sleep(3000);
        System.out.println(thread1.getState());//WAITING

        new Thread(() -> {
            synchronized (SYNCHRO_STATE) {
                SYNCHRO_STATE.notify();
            }
        }).start();
        Thread.sleep(5000);
        System.out.println(thread1.getState());//TERMINATED

    }

    private static void run() {
        synchronized (SYNCHRO_STATE) {
            try {
                Thread.sleep(4000);
                SYNCHRO_STATE.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
