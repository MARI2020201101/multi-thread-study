package thread.support;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads sample = new RunSupportThreads();
     //   sample.runSleepThread();
        sample.checkJoin();
    }

    private void runSleepThread() {
        try {
           SleepThread sleepThread = new SleepThread(2000);
           System.out.println("sleep thread state: "+sleepThread.getState());//NEW
           sleepThread.start();
           System.out.println("started-----------------------------");
           System.out.println("sleep thread state: "+sleepThread.getState());//RUNNABLE: 나 일할수있어요!

           Thread.sleep(1000);
            System.out.println("sleep-----------------------------");
            System.out.println("sleep thread state: "+sleepThread.getState());//내부에서 WAITING중
            sleepThread.join();
            sleepThread.interrupt();
            System.out.println("interrupt-----------------------------");
            System.out.println("sleep thread state: "+sleepThread.getState());//TERMINATED: interrupt로 인해 중단됨
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkJoin(){
        SleepThread thread = new SleepThread(2000);
        try{
            thread.start();
            thread.join(500);
            //0.5초만 기다려주기 때문에 아래에서 exception터지면서 스레드가 interrupt되면서 종료됨
            //매개변수 없는 join()은 끝날때까지 계속 기다려줌.
            thread.interrupt();//sleepinterruped
            System.out.println("sleep thread state : "+thread.getState());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
