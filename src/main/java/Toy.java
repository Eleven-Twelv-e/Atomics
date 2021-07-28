public class Toy extends Thread {

    @Override
    public void run() {
        final int waitTime = 1500;
        Tumbler tumbler = Tumbler.getTumbler();
        Thread thread = Thread.currentThread();

        while (thread.isAlive() && !thread.isInterrupted()) {
            if (tumbler.isTumblerCondition()) {
                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tumbler.setTumblerCondition(false);
                System.out.println("Cat touch tumbler and closed the box");
                boxStatus();
            }
        }
    }

    public void boxStatus() {
        System.out.println("Box is " + (Tumbler.getTumbler().isTumblerCondition() ? "opened" : "closed"));
    }
}
