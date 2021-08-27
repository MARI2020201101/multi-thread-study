package thread;

public class NameCalcThread extends Thread{

    private int calcNumber=0;
    private String name;
    public NameCalcThread(String name,int calcNumber) {
        super(name);
        this.name= name;
        this.calcNumber = calcNumber;
    }

    @Override
    public void run() {
        for (int i =0 ; i<calcNumber;i++){
            System.out.println("running with calcNumber : "+i);
        }

    }
}
