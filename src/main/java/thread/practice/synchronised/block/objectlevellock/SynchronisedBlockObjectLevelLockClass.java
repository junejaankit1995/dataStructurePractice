package thread.practice.synchronised.block.objectlevellock;

public class SynchronisedBlockObjectLevelLockClass {

    public  void synMethod1() throws InterruptedException {
        System.out.println("Non Synchronised Block Running Started by synMethod1 .");
        for(int i = 0; i < 4; i++) {
            //Thread.sleep(2000);
            System.out.println(this.getClass().getName() + " Non Synchronised Running synMethod1 with i : {}." + i);
        }
        System.out.println("Non Synchronised Block Running Completed by synMethod1 .");
        synchronized (this) {
            for (int i = 0; i < 4; i++) {
                //Thread.sleep(2000);
                System.out.println(this.getClass().getName() + " Running synBlock1 with i : {}." + i);
            }
        }
    }

    public void synMethod2() throws InterruptedException {
        System.out.println("Non Synchronised Block Running Started by synMethod2 .");
        for(int i = 0; i < 4; i++) {
            //Thread.sleep(2000);
            System.out.println(this.getClass().getName() + " Non Synchronised Running synMethod2 with i : {}." + i);
        }
        System.out.println("Non Synchronised Block Running Completed by synMethod2 .");
        synchronized (this) {
            for (int i = 0; i < 4; i++) {
                //Thread.sleep(2000);
                System.out.println(this.getClass().getName() + " Running synMethod2 with i : {}." + i);
            }
        }
    }

}
