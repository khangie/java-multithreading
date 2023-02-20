package demo5;

/*
 * Running multiple threads using the synchronized keyword
 * https://www.udemy.com/course/java-multithreading/learn/lecture/108950#overview
 */

public class SynchronizedKeywordApp {

    private int count = 0;

    // The "synchronized" keyword ensures that only one thread is accessing the variable count at a time
    public synchronized void increment() {
        count++;
    }

    public void doWork() {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);

    }

    public static void main(String[] args) {
        SynchronizedKeywordApp app = new SynchronizedKeywordApp();
        app.doWork();
    }

}
