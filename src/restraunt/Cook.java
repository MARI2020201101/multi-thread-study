package restraunt;

public class Cook extends Thread{
    private Table table;
    Cook(Table table){
        this.table = table;
    }

    @Override
    public void run() {
        while(true){
            int idx = (int) (Math.random()*table.dishNum());
            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
