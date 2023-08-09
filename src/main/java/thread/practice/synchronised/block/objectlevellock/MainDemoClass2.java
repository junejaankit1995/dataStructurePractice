package thread.practice.synchronised.block.objectlevellock;


public class MainDemoClass2 {

    public static void main(String[] args) {
        SynchronisedBlockObjectLevelLockClass obj1 = new SynchronisedBlockObjectLevelLockClass();
        ThreadDemoClass t1Thread = new ThreadDemoClass();
        t1Thread.setThreadSafeObj(obj1);

        ThreadDemoClass t2Thread = new ThreadDemoClass();
        SynchronisedBlockObjectLevelLockClass obj2 = new SynchronisedBlockObjectLevelLockClass();
        t2Thread.setThreadSafeObj(obj2);
        //t2Thread.setThreadSafeObj(obj1);


        t1Thread.start();
        t2Thread.start();


    }
}
