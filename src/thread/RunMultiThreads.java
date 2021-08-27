package thread;

public class RunMultiThreads {
    public static void main(String[] args) {
        RunMultiThreads runMultiThreads = new RunMultiThreads();
        runMultiThreads.runMultiThread();
        System.out.println("Run multiThread method is ended..........");

    }

    private void runMultiThread() {
        RunnableSample[] runnableSamples = new RunnableSample[10];
        ThreadSample[] threadSamples = new ThreadSample[10];
        for (int i=0; i<10; i++){
            runnableSamples[i] = new RunnableSample();
            threadSamples[i] = new ThreadSample();
            new Thread(runnableSamples[i]).start();
            threadSamples[i].start();
        }
    }
}
