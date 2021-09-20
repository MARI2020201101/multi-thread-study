package thread2;


import javax.swing.*;

class MyThread extends Thread{
    @Override
    public void run() {
        int i = 10;
        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
               // interrupt();
            }
        }
        System.out.println("카운트 종료...");
    }
}
public class ThreadEx {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        String input = JOptionPane.showInputDialog("input....");
        System.out.println("input is : " +input);
        myThread.interrupt();
        System.out.println("is interruped : " +myThread.isInterrupted());
    }

}
