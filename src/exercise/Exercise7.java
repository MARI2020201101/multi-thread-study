package exercise;

public class Exercise7 {
    static boolean stop = false;
    public static void main(String[] args) throws Exception {
        new MyThread5().start();
        try{
            Thread.sleep(6000);
        }catch (Exception e){

        }
        stop=true;
        System.out.println("stop");
    }

    static class Thread5 extends Thread{
        @Override
        public void run() {
            for(int i=0;Exercise7.stop==false;i++){
                System.out.println(i);
                try{
                    Thread.sleep(3000);
                }catch (Exception e){
                }
            }
        }
    }

    static class MyThread5 extends Thread{
        @Override
        public void run() {
            int i =0;
           while(!Exercise7.stop){
               System.out.println(i);
               i++;
               try {
                   Thread.sleep(3000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }
    }
}
