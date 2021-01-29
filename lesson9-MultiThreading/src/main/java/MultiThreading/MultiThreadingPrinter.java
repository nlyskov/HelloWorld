package MultiThreading;

import java.util.concurrent.TimeUnit;

public class MultiThreadingPrinter {
    private static final String str = "1 2 3 4 5 6 7 8 9 10 9 8 7 6 5 4 3 2 1";
    private String last = "Thread 2";
    public static void main(String[] args) throws InterruptedException {
        new MultiThreadingPrinter().go();
    }

    synchronized private void inc() {
        String[] numbers = str.split(" ");
        for (String number : numbers) {
            try {
                if (last.equals(Thread.currentThread().getName())) {
                    wait();
                }
                System.out.println("Текущий поток: '"+Thread.currentThread().getName()+"': "+number);
                last = Thread.currentThread().getName();
                Thread.sleep( TimeUnit.MILLISECONDS.toMillis( 500 ) );
                notifyAll();
            }
             catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
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