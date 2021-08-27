package thread.group;

import thread.support.SleepThread;

public class RunGroupThreads {
    public static void main(String[] args) {
        RunGroupThreads runGroupThreads = new RunGroupThreads();
        runGroupThreads.groupThread();
    }

    private void groupThread() {
        try {
            SleepThread sleep1 = new SleepThread(5000);
            SleepThread sleep2 = new SleepThread(5000);

            ThreadGroup threadGroup = new ThreadGroup("group");
            Thread thread1 = new Thread(threadGroup,sleep1);
            Thread thread2 = new Thread(threadGroup,sleep2);

            thread1.start();
            thread2.start();
            Thread.sleep(1000);
            System.out.println("Group name : "+ threadGroup.getName());
            System.out.println("Group active count :"+ threadGroup.activeCount());
            threadGroup.list();

            Thread[] tempThreadList = new Thread[threadGroup.activeCount()];
            int result = threadGroup.enumerate(tempThreadList);
            System.out.println("Enumerate List result: "+result);
            for (Thread thread : tempThreadList) {
                System.out.println(thread);
            }

        }catch (Exception e){

        }
    }
}
