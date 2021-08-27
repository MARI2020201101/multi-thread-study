package thread.sync;

public class RunSync {
    public static void main(String[] args) {
        System.out.println("main start...................");
        RunSync runSync = new RunSync();
        runSync.runAnotherThreads();
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
            calculate.getAndPrintAmount();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void runAnotherThreads() {
        CommonCalculate calculate1 = new CommonCalculate();
        CommonCalculate calculate2 = new CommonCalculate();
        ModifyAmountThread amountThread1 = new ModifyAmountThread(calculate1,true);
        ModifyAmountThread amountThread2 = new ModifyAmountThread(calculate2,true);
        amountThread1.start();
        amountThread2.start();

        try {
            amountThread1.join();
            amountThread2.join();
            calculate1.getAndPrintAmount();
            calculate2.getAndPrintAmount();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
