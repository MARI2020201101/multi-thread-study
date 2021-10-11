package exercise;

import javax.swing.*;

public class Exercise9 {
    public static void main(String[] args) {
        Exercise9Th th = new Exercise9Th();
        th.start();

        String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
        System.out.println("입력하신 값은 "+input+"입니다");
        th.interrupt();
        //10초동안 입력이 없으면 자동 종료되어야 한다. 입력이 10초안에 이루어진경우 . 입력받는 즉시 종료되도록 수정하시오.
    }
}
class Exercise9Th extends Thread{
    @Override
    public void run() {
        int i = 10;
        while(i!=0 && isInterrupted()){
            System.out.println(i--);

            try{
                Thread.sleep(1000);
            }catch (Exception e){}
        }
        System.out.println("count 종료");
    }
}