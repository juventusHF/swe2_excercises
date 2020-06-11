package ch.juventus.threads;

public class ThreadInfo implements Runnable {

    @Override
    public void run() {
        System.out.println("Current thread: " + Thread.currentThread().getName());
    }
}
