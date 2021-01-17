package MultiThreading;

import java.util.concurrent.TimeUnit;

public class MultiThreadingPrinter {
    private static final String str = "1 2 3 4 5 6 7 8 9 10 9 8 7 6 5 4 3 2 1";
    public static void main(String[] args) throws InterruptedException {
        new MultiThreadingPrinter().go();
    }

    synchronized private void inc() {
        String[] numbers = str.split(" ");
        for (String number : numbers) {
            if (Thread.currentThread().getName().equals("Thread 1")) {
                System.out.println("Текущий поток: '"+Thread.currentThread().getName()+"': "+number);
            } else {
                System.out.println("Текущий поток: '"+Thread.currentThread().getName()+"': "+number);
            }
            try {
                notify();
                Thread.sleep( TimeUnit.MILLISECONDS.toMillis( 100 ) );
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.currentThread().interrupt();
        notifyAll();
    }

    private void go() throws InterruptedException {
        Thread firstThread = new Thread(this::inc);
        Thread secondThread = new Thread(this::inc);

        firstThread.setName("Thread 1");
        secondThread.setName("Thread 2");

        firstThread.start();
        secondThread.start();
    }
}
