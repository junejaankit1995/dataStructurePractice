package thread.practice.synchronised.block.objectlevellock;

import thread.practice.synchronised.SynchronisedMethodClass;

public class ThreadDemoClass extends Thread {

    SynchronisedBlockObjectLevelLockClass threadSafeObj;

    public void run() {
        try {
            System.out.println("ThreadDemoClass Running its run method.");
            threadSafeObj.synMethod1();
            Thread.sleep(3000);
            System.out.println("ThreadDemoClass completed Running its run method.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setThreadSafeObj(SynchronisedBlockObjectLevelLockClass threadSafeObj) {
        this.threadSafeObj = threadSafeObj;
    }

}
