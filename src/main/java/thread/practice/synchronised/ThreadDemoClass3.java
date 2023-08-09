package thread.practice.synchronised;

public class ThreadDemoClass3 extends Thread {

    SynchronisedMethodClass threadSafeObj;

    public void run() {
        try {
            threadSafeObj.normalMethod();
            System.out.println(Thread.currentThread().getName() + "Running its run method.");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "completed Running its run method.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setThreadSafeObj(SynchronisedMethodClass threadSafeObj) {
        this.threadSafeObj = threadSafeObj;
    }

}
