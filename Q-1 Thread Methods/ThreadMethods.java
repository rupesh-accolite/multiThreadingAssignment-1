public class ThreadMethods implements Runnable{
    @Override
    public void run() {

        System.out.println("Hello, "+Thread.currentThread().getName()+". Your ID is: "+Thread.currentThread().getId());
        try{
            System.out.println("The thread is going to sleep for 10 seconds");
            Thread.sleep(10000);
            System.out.println();
        }
        catch (InterruptedException e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        ThreadMethods threadMethods = new ThreadMethods();
        Thread firstThread = new Thread(threadMethods);
        Thread secondThread = new Thread(threadMethods);
        firstThread.start();
        secondThread.start();

        System.out.println("Active thread count is: "+Thread.activeCount());
        System.out.println();
        System.out.println("Priority of first thread: "+firstThread.getPriority());
        System.out.println("Priority of second thread: "+secondThread.getPriority());
        System.out.println();
        System.out.println("First Thread State: "+firstThread.getState());
        System.out.println("Second Thread State: "+secondThread.getState());
        System.out.println();
        secondThread = new Thread(threadMethods);
        secondThread.interrupt();
        System.out.println("Is second thread interrupted? " + secondThread.isInterrupted() );
        System.out.println("Is second thread alive? " + secondThread.isAlive());
        System.out.println();
        firstThread = new Thread(threadMethods);
        firstThread.setDaemon(true);
        System.out.println("Is first thread a daemon thread? " + firstThread.isDaemon());
        System.out.println("Is first thread interrupted? " + firstThread.isInterrupted());
        System.out.println();
        System.out.println("First thread waiting for second thread to join");
        try
        {
            secondThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println();
        secondThread.setName("Second Thread");
        System.out.println("New name set for second thread: " + secondThread.getName());
        System.out.println();
        secondThread.setPriority(1);
        System.out.println();
        System.out.println(firstThread.toString());
        System.out.println(secondThread.toString());
        System.out.println();
        System.out.println(Thread.getAllStackTraces());
        System.out.println();
        ThreadGroup group = firstThread.getThreadGroup();
        System.out.println("ThreadGroup to which first thread belongs " +group.toString());


    }
}
