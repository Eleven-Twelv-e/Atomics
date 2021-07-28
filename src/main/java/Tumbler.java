public class Tumbler {

    private static Tumbler tumbler;
    private volatile boolean tumblerCondition = false;

    public static synchronized Tumbler getTumbler() {
        if (tumbler == null) {
            tumbler = new Tumbler();
        }
        return tumbler;
    }


    public void setTumblerCondition(boolean tumblerCondition) {
        this.tumblerCondition = tumblerCondition;
    }

    public boolean isTumblerCondition() {
        return tumblerCondition;
    }
}
