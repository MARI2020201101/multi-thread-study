package thread;

public class RunThreads{
    public static void main(String[] args) {
        RunThreads threads = new RunThreads();
        threads.runBasic();
        System.out.println("Thread methods ended.....");
    }

    private void runBasic() {
        RunnableSample rs = new RunnableSample();
        ThreadSample ts = new ThreadSample();
        new Thread(rs).start();
        ts.start();
    }
}
