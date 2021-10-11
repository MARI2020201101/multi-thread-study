package exercise;

import java.util.Scanner;
import java.util.Vector;

import static exercise.Exercise8.data;
import static exercise.Exercise8.words;

public class Exercise8 {

    static Vector words = new Vector();
    static String[] data = {"태연","유리","윤아", "효연","수영","서현","티파니","써니","제시카"};
    static int interval = 2*1000;
    WordGenerator wg = new WordGenerator();

    public static void main(String[] args) {
        Exercise8 game = new Exercise8();
        game.wg.start();

        Vector words= game.words;

        while(true){
            System.out.println(words);
            System.out.println(">>");
            Scanner s= new Scanner(System.in);
            String input = s.nextLine().trim();

            int index = words.indexOf(input);
            if(index!=-1){
                words.remove(index);
            }

        }
    }
}
class WordGenerator extends Thread{
    @Override
    public void run() {
        //1. interval마다 배열 data의 값중 하나를 임의로 선택해서 words에 저장한다
        //2. 단어 연습게임 . 타자2초안에 치고-지우고.
        while(true){
            int idx = (int) (Math.random() * (data.length));
            String word =data[idx];
            words.add(word);
            System.out.println(words);
            try {
                Thread.sleep(Exercise8.interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
