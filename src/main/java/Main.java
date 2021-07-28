import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws InterruptedException{
            LongAdder counter = new LongAdder();
            int processors = Runtime.getRuntime().availableProcessors();
            ExecutorService executorService = Executors.newFixedThreadPool(processors);

            Loan shop1 = new Loan(3,counter,"RRS");
            Loan shop2 = new Loan(5, counter, "YMN");
            Loan shop3 = new Loan(5, counter, "YNP");

            executorService.submit(shop1);
            executorService.submit(shop2);
            executorService.submit(shop3);

            executorService.awaitTermination(3,TimeUnit.SECONDS);

            System.out.println("Total Amaunt " + counter.sum());
            executorService.shutdown();

        }
    }

