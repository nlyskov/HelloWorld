package lesson3;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws InterruptedException {
        App.go(1000000);
    }

    private static void go( int amount) throws InterruptedException{
        var list = new ArrayList<Integer>();
        while (true){
            for (int i = 0; i < amount; i++) {
                var b = Integer.valueOf(i);
                list.add(b);
            }
            Thread.sleep(7000);
        }
    }
}
