package exercise;

public class Exercise6 {
    public static void main(String[] args) throws Exception {
        Thread4 thread4 = new Thread4();
        thread4.setDaemon(true);
        thread4.start();
        try{
            Thread.sleep(5000);
        }catch (Exception e){

        }
        throw new Exception("꽝~~~");
    }

    static class Thread4 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(i);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                }
            }
        }
    }
}
