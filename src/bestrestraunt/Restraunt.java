package bestrestraunt;



public class Restraunt {
    public static void main(String[] args) throws InterruptedException {
       Table table = new Table();
        Cook cook = new Cook(table);
        new Thread(cook,"COOK1").start();
        Customer customer1 = new Customer(table,"donut");
        Customer customer2 = new Customer(table, "cookie");
        new Thread(customer1, "CUST1").start();
        new Thread(customer2, "CUST2") .start();

        Thread.sleep(5000);
        System.exit(0);
    }
}
