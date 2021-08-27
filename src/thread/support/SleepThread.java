package thread.support;

public class SleepThread extends Thread{
    private long sleepTime;
    public SleepThread(long sleepTime){
        this.sleepTime=sleepTime;
    }

    @Override
    public void run() {
        try {
            System.out.println("sleeping..........."+this.getName());
            sleep(sleepTime);
            System.out.println("stopping..........."+this.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
