package com.tszala.fp;

import java.util.concurrent.*;

public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        Runnable producer = () -> {
            Integer producedElement = ThreadLocalRandom
                    .current()
                    .nextInt();
            try {
                System.out.println("Saving element " + producedElement);
                queue.put(producedElement);
                System.out.println("Saving element " + (producedElement + 1));
                queue.put(producedElement + 1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };

        Runnable consumer = () -> {
            try {
                Integer consumedElement = queue.take();
                System.out.println("Consumed element " + consumedElement);
                Integer consumedElement2 = queue.take();
                System.out.println("Consumed element2 " + consumedElement2);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        };

        executor.execute(producer);
        executor.execute(consumer);

        executor.awaitTermination(500, TimeUnit.MILLISECONDS);
        executor.shutdown();
        //assertEquals(queue.size(), 0);
    }
}
