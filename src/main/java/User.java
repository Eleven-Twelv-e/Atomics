public class User extends Thread {


    @Override
    public void run() {

        final int waitTime = 2000;
        final int numOfiteration = 10;

        Tumbler tumbler = Tumbler.getTumbler();
        for (int i = 0; i < numOfiteration; i++) {
            tumbler.setTumblerCondition(true);
            System.out.println("User touch tumbler and open the box");
            boxStatus();
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("User dont want to play !");
        boxStatus();
    }

    public void boxStatus() {
        System.out.println("Box is " + (Tumbler.getTumbler().isTumblerCondition() ? "opened" : "closed"));
    }
}
