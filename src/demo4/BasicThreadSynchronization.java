package demo4;

/*
 * Basic thread synchronization using volatile keyword
 * https://www.udemy.com/course/java-multithreading/learn/lecture/108943#overview
 */

import java.util.Scanner;

class Processor extends Thread {

    // The "volatile" keyword ensures that the variable is not cached in the thread
    // so that changes to the variable are detected in the thread.
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class BasicThreadSynchronization {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        // Get input from the console
        System.out.println("Press return to stop...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }
}
