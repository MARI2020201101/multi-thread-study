package thread2;

class MyGCThread extends Thread{
    final static int MAX_MEMORY = 1000;
    int usedMemory = 0;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10*1000);
            } catch (InterruptedException e) {
                System.out.println("awaken by interrupt..");
            }
            gc();
            System.out.println("garbage collected. free memory : " +freeMemory());
        }
    }
    public int totalMemory(){
        return MAX_MEMORY;
    }
    public int freeMemory() {
        return MAX_MEMORY-usedMemory;
    }

    private void gc() {
        usedMemory -=300;
        if(usedMemory < 0){
            usedMemory =0;
        }
    }
}
public class ThreadEx2 {
    public static void main(String[] args) throws InterruptedException {
        MyGCThread thread = new MyGCThread();
        thread.setDaemon(true);
        thread.start();

        int requiredMemory = 0;
        for(int i = 0 ; i <20; i++){
            requiredMemory = (int) (Math.random()*10)*20;

            if(thread.freeMemory()<requiredMemory ||
                thread.freeMemory() < thread.totalMemory()*0.4){

                thread.interrupt();
                thread.join();
            }
            thread.usedMemory += requiredMemory;
            System.out.println("usedMemory : "+ thread.usedMemory);
        }
    }

}
