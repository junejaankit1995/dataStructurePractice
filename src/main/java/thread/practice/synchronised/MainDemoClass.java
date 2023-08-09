package thread.practice.synchronised;

public class MainDemoClass{

    public static void main(String[] args) {
        SynchronisedMethodClass obj1 = new SynchronisedMethodClass();
        ThreadDemoClass t1Thread = new ThreadDemoClass();
        t1Thread.setThreadSafeObj(obj1);

        ThreadDemoClass2 t2Thread = new ThreadDemoClass2();
        t2Thread.setThreadSafeObj(obj1);

        ThreadDemoClass3 t3Thread = new ThreadDemoClass3();
        t3Thread.setThreadSafeObj(obj1);

        t1Thread.start();
        t2Thread.start();
        t3Thread.start();


    }
}
