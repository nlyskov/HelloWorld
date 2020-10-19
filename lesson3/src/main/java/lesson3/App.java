package lesson3;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws InterruptedException {
        App.go(10000);
    }

    private static void go( int amount) throws InterruptedException{
        var list = new ArrayList<Integer>();
        while (true){
            for (int i = 0; i < amount; i++) {
                list.add(i);
            }
            for (int i = 0; i < 5000; i++) {
                list.remove(i);
            }
//            System.out.println(list);
//            Thread.sleep(1000);
        }
    }
}
