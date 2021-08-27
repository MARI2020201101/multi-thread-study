package thread.sync;

public class CommonCalculate {
    private int amount;
    public CommonCalculate(){
        this.amount=0;
    }
    public void plus(int val){
        amount +=val;
    }
    public void minus(int val){
        amount -=val;
    }
    public int getAndPrintAmount(){
        System.out.println("amount : " + amount);
        return amount;
    }
}
