package demo2;

/*
 * Runs a thread passing the Runnable in the constructor of the thread.
 * https://www.udemy.com/course/java-multithreading/learn/lecture/107238#overview
 */

class Runner implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class StartingThreadsConstructor {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());
        t1.start();
        t2.start();
    }
}
