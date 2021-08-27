package thread.sync;

public class CommonCalculate {
    private int amount;
    private int interest;
    Object lock1 = new Object();
    Object lock2 = new Object();
    public CommonCalculate(){
        this.amount=0;
        this.interest=0;
    }
    public void addInterest(int val){
     //   synchronized (lock1){
            interest+=val;
     //   }

    }
    public void plus(int val){
        synchronized (lock1){
            amount +=val;
        }

    }
    public synchronized void minus(int val){
        amount -=val;
    }
    public int getAndPrintAmount(){
        System.out.println("amount : " + amount);
        System.out.println("interest : " + interest);
        return amount;
    }
}
