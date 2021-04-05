public class CustomThread {

    public static void main(String[] args) {
        Animal a1= new Animal("tom","cat");
        Animal a2= new Animal("bashooka","tiger");

        MyThread thread1 = new MyThread(a1);
        MyThread thread2 = new MyThread(a1);

        MyThread thread3 = new MyThread(a2);
        MyThread thread4 = new MyThread(a2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    private static class MyThread extends Thread{

        Animal animal; // member variable

        public MyThread(Animal animal){
            this.animal=animal;
        }

        @Override
        public void run() {

            // object level Synchronization
//            synchronized (this.animal) { // basically lock on the object. this lead thread to run sequentially(one thread of one each) but if we remove the synchronized block then thread run in paralleled.
//                System.out.println("current thread :" + currentThread().getName() +", animal :"+this.animal);
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            // object level synchronization
            synchronized (Animal.class) { // one at the time.
                System.out.println("current thread :" + currentThread().getName() +", animal :"+this.animal+",  thread object :"+this);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
