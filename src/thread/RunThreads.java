package thread;

public class RunThreads{
    public static void main(String[] args) {
        RunThreads threads = new RunThreads();
        threads.runBasic();
        threads.runNamedThread(10, "named Threads runrun");
        System.out.println("Thread methods ended.....");
        //메인 메소드가 먼저 끝나고, 스레드들이 끝남. 살아있는 스레드가 있으면 JVM은 종료되지 않음.
    }

    private void runBasic() {
        RunnableSample rs = new RunnableSample();
        ThreadSample ts = new ThreadSample();
        new Thread(rs).start();
        ts.start();
    }

    private void runNamedThread(int number, String name){
        NameCalcThread nameCalcThread = new NameCalcThread(name,number);
        nameCalcThread.start();
    }
}
