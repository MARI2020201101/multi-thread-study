package bestrestraunt;

import static java.lang.Thread.sleep;

public class Cook  implements Runnable{
    private Table table;

    public Cook(Table table){
        this.table = table;
    }

    @Override
    public void run() {
        while(true){
            int idx = (int) (Math.random()*3);

                table.add(table.dishNames[idx]);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
