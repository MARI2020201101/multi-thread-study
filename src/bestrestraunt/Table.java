package bestrestraunt;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Table {
    public static final int MAX_DISHES = 6;
    private ArrayList<String> dishes = new ArrayList<>();
    String[] dishNames ={"donut","donut","cookie"};

    private ReentrantLock lock = new ReentrantLock();
    private Condition forCook = lock.newCondition();
    private Condition forCust = lock.newCondition();


    public void add(String dishName){
        lock.lock();
        try{
            while(dishes.size()>=MAX_DISHES){
                String name = Thread.currentThread().getName();
                System.out.println(name + "is waiting......");

                try {
                    forCook.await();
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            dishes.add(dishName);
            forCust.signal();
            System.out.println(dishes.toString());
        }finally {
            lock.unlock();
        }

    }

    public void remove(String dishName){
        lock.lock();
        String name = Thread.currentThread().getName();
        try{
            while(dishes.size()==0){

                System.out.println(name + "is waiting......");
                try{
                    forCust.await();
                    Thread.sleep(500);
                }catch (Exception e){}
            }
            while(true){
                for(int i = 0 ; i < dishes.size() ; i ++){
                    if(dishes.get(i).equals(dishName)){
                        dishes.remove(i);
                        forCook.signal();

                    }
                }
                try{
                    System.out.println(name +" is waiting..... ");
                    forCust.await();
                    Thread.sleep(500);

                }catch (Exception e){}
            }

        }finally {
            lock.unlock();
        }
    }
}
