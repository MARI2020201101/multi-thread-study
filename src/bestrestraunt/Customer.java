package bestrestraunt;

public class Customer implements Runnable {
    private Table table;
    private String food;

    public Customer(Table table , String food){
        this.table= table;
        this.food = food;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            table.remove(food);
                String name = Thread.currentThread().getName();
                System.out.println(name + "ate food....");
            }

        }
    }


