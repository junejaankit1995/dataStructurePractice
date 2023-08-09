package thread.practice.synchronised;

public class SynchronisedMethodClass {

    public synchronized void synMethod1() throws InterruptedException {
        for(int i = 0; i < 4; i++) {
            Thread.sleep(2000);
            System.out.println(this.getClass().getName() + "Running synMethod1 with i : {}." + i);
        }
    }

    public synchronized void synMethod2() throws InterruptedException {
        for(int i = 0; i < 4; i++) {
            Thread.sleep(2000);
            System.out.println(this.getClass().getName() + "Running synMethod2 with i : {}." + i);
        }
    }

    public void normalMethod() throws InterruptedException {
        for(int i = 0; i < 4; i++) {
            Thread.sleep(2000);
            System.out.println(this.getClass().getName() + "Running normatMethod with i : {}." + i);
        }
    }
}
