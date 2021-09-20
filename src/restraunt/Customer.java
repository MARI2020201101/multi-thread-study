package restraunt;

public class Customer extends Thread{
    private Table table ;
    private String food;

    Customer(Table table , String food ){
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            }catch(Exception e){
            }
            String name = Thread.currentThread().getName();
            try {
                if(eatFood()){
                    System.out.println(name + " ate a " + food);
                }else{
                    System.out.println(name + " is hungry.......");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean eatFood() throws InterruptedException {
        return table.remove(food);
    }
}
