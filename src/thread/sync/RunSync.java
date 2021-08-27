package thread.sync;

public class RunSync {
    public static void main(String[] args) {
        System.out.println("main start...................");
        RunSync runSync = new RunSync();
        runSync.runThreads();
        System.out.println("main end...................");

    }

    private void runThreads() {
        CommonCalculate calculate = new CommonCalculate();
        ModifyAmountThread amountThread1 = new ModifyAmountThread(calculate,true);
        ModifyAmountThread amountThread2 = new ModifyAmountThread(calculate,true);
        amountThread1.start();
        amountThread2.start();

        try {
            amountThread1.join();
            amountThread2.join();
            System.out.println("Final value is : "+ calculate.getAndPrintAmount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
