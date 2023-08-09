package thread.practice.synchronised.block.objectlevellock;

import thread.practice.synchronised.SynchronisedMethodClass;

public class ThreadDemoClass2 extends Thread {

    SynchronisedBlockObjectLevelLockClass threadSafeObj;

    public void run() {
        try {
            System.out.println("ThreadDemoClass2 Running its run method.");
            threadSafeObj.synMethod2();
            Thread.sleep(3000);
            System.out.println("ThreadDemoClass2 complete running its run method.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void setThreadSafeObj(SynchronisedBlockObjectLevelLockClass threadSafeObj) {
        this.threadSafeObj = threadSafeObj;
    }

}
