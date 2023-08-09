package thread.practice.synchronised;

public class ThreadDemoClass2 extends Thread {

    SynchronisedMethodClass threadSafeObj;

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "Running its run method.");
            threadSafeObj.synMethod2();
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "complete running its run method.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setThreadSafeObj(SynchronisedMethodClass threadSafeObj) {
        this.threadSafeObj = threadSafeObj;
    }

}
