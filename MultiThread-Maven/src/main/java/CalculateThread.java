public class CalculateThread {
    public static void main(String[] args) throws InterruptedException {

        MyThread t1=  new MyThread();
        MyThread t2 = new MyThread();

        long start = System.currentTimeMillis();
        t1.start(); // 10 sec
        t2.start(); // 15 sec

        t1.join(); // 10 sec
        t2.join(); // 5 sec

        System.out.println(t1.result - t2.result);
        long end = System.currentTimeMillis();
    }

    public static class MyThread extends Thread{

        private int result;

        @Override
        public void run() {
            long start = System.currentTimeMillis();

            // finding the sum of square

            long end = System.currentTimeMillis();
        }
    }
}
