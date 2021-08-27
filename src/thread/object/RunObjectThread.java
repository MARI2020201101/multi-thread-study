package thread.object;

public class RunObjectThread {
    public static void main(String[] args) {
        RunObjectThread runObjectThread = new RunObjectThread();
        runObjectThread.runThread2();
    }

    private void runThread() {
        try{
            Object monitor =new Object();
            StateThread stateThread = new StateThread(monitor);
            System.out.println("state thread : " + stateThread.getState());
            stateThread.start();
            System.out.println("started------------------------------------");
            System.out.println("state thread : " + stateThread.getState());
            Thread.sleep(100);
            System.out.println("sleep 0.1 second------------------------------------");
            System.out.println("state thread : " + stateThread.getState());
            synchronized (monitor){
                monitor.notify();
            }
            Thread.sleep(100);
            System.out.println("notified------------------------------------");
            System.out.println("state thread : " + stateThread.getState());
            stateThread.join();
            System.out.println("joined------------------------------------");
            System.out.println("state thread : " + stateThread.getState());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void runThread2() {
        try{
            Object monitor =new Object();
            StateThread stateThread1 = new StateThread(monitor);
            StateThread stateThread2= new StateThread(monitor);
            System.out.println("state thread : " + stateThread1.getState());
            stateThread1.start();
            stateThread2.start();
            System.out.println("started------------------------------------");
            System.out.println("state thread : " + stateThread1.getState());
            Thread.sleep(100);
            System.out.println("sleep 0.1 second------------------------------------");
            System.out.println("state thread : " + stateThread1.getState());
            synchronized (monitor){
              //  monitor.notify();
              //  monitor.notify();
                monitor.notifyAll();
            }
            Thread.sleep(100);
            System.out.println("notified------------------------------------");
            System.out.println("state thread : " + stateThread1.getState());
            stateThread1.join();
            stateThread2.join();
            System.out.println("joined------------------------------------");
            System.out.println("state thread : " + stateThread1.getState());
            System.out.println("state thread : " + stateThread2.getState());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
