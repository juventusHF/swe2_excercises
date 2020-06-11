package ch.juventus.threads;

public class ThreadInfoExample {

    public static void main(String[] args) {
        Runnable r = new ThreadInfo();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        System.out.println("State thread 1 " + t1.getState());
        System.out.println("State thread 2 " + t2.getState());

        t1.start();

        System.out.println("State thread 1 " + t1.getState());
        System.out.println("State thread 2 " + t2.getState());

        t2.start();

        System.out.println("State thread 1 " + t1.getState());
        System.out.println("State thread 2 " + t2.getState());
    }
}
