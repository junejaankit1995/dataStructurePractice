package thread.practice;

public class DeadLockMainThread {

    public static void main(String[] args) throws InterruptedException {
        //Assigning main thread to child thread static data member
        ChildThread.mt = Thread.currentThread();
        ChildThread childThread = new ChildThread();
        childThread.start();
        // Main Thread is waiting for child thread to complete
        //childThread.join();
        for(int i = 0; i < 5; i++) {
            System.out.println("Main thread calling run method "+ i);
        }
    }
}
