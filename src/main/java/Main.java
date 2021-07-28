public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread user = new User();
        Thread toy = new Toy();
        user.start();
        toy.start();

        user.join();
        toy.interrupt();
    }

}
