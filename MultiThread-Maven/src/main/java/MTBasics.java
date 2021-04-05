public class MTBasics {
    public static void main(String[] args) throws InterruptedException {
        MTBasics o = new MTBasics(); // use this for making class static free
        MyThread thread = o.new MyThread(); // this is for extends thread
//        thread.start();
//        thread.run(); // its just calling function in the same thread .its not multithreading.
//        thread.start();  //it will give you this execpetion beacause your main program stops.
        //Exception in thread "main" java.lang.IllegalThreadStateException
        //	at java.lang.Thread.setDaemon(Thread.java:1356)
        //	at MTBasics.main(MTBasics.java:13)

        // we Dubug the code using breakpoint


        try{
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("thread 0 is "+ thread.isAlive());
            thread.interrupt();
            Thread.sleep(2000);
            System.out.println("thread 0 is "+ thread.isAlive());

//            Thread.currentThread().isAlive(); //  check for main thread is alive or not

        }catch(Exception e){
            System.out.println("Application has stopped forcefully");
            thread.interrupt();
        }

//       Thread.sleep(40000);

         // for runnable interface
//        Thread thread = new Thread(o.new MyThread());
//        thread.start();
//        thread.run();
    }


    private class MyThread extends Thread {

        @Override
        public void run() {
//            System.out.println("in thread :"+ currentThread().getName());
            try {
                System.out.println("in thread Before sleep :" + Thread.currentThread().getName());
                currentThread().sleep(30000);
                System.out.println("in thread after sleep :" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.out.println("Application has stopped forcefully");
            }
        }

        // for thread dump -> [jstack pid > thread_dump.txt] where pid is process id gte from task manager
        // then you can review this txt using jstack.review

//    private class MyThread extends Animal implements Runnable{
//
//        public void run() {
//            System.out.println("in Thread:"+Thread.currentThread().getName());
//        }
//    }
    }
}

