package thread.practice;

public class ChildThread extends Thread{

    public static Thread mt;

    public void run() {
        try{
            //Child thread is waiting for main thread to complete.
            mt.join();
        }catch (InterruptedException e) {
            System.out.println("Interupted Exception occur at Child Thread.");
        }
        for(int i = 0; i < 5; i++) {
            System.out.println("Child thread calling run method "+ i);
        }
    }
}
