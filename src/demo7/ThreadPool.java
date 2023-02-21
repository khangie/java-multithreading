package demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * Run multiple threads using a Thread Pool which re-uses threads and is more efficient than starting
 * a new thread every time.
 * https://www.udemy.com/course/java-multithreading/learn/lecture/108992#overview
 */

class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Completed: " + id);
    }
}
public class ThreadPool {
    public static void main(String[] args) {

        // Define new thread pool of 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Run tasks based on available thread pools
        for (int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }

        // Stop accepting new tasks when all the tasks are finished
        executor.shutdown();

        System.out.println("All tasks submitted.");

        // Wait up to 1 day before proceeding
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");

    }

}
