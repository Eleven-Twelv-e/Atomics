import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Loan implements Runnable {

    LongAdder count;
    int number;
    String name;
    Random rn = new Random();
    final int bn = 100;

    public Loan(int number, LongAdder count,String name) {
        this.count = count;
        this.number = number;
        this.name = name;
    }


    @Override
    public void run() {
        List<Integer> list = new ArrayList<>();
        Thread.currentThread().setName(name);

        for (int i = 0; i < number; i++) {
            list.add(rn.nextInt(), bn);
        }
        System.out.printf("%s has in cash %s%n", Thread.currentThread().getName(), list);
        for (Integer i : list) {
            count.add(i);
        }
    }
}
