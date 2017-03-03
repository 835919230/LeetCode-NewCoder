/**
 * Created by hexi on 16-10-16.
 */
public class ThreadGroupAndPool {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程的名字："+mainGroup.getName());
        System.out.println("主线程是否是后台线程："+mainGroup.isDaemon());

        MyThread t = new MyThread(mainGroup, "主线程的线程");
        t.start();


        ThreadGroup tg = new ThreadGroup("新线程组");
        tg.setDaemon(true);
        System.out.println("tg线程组是否是后台线程组：" + tg.isDaemon());

        MyThread tt = new MyThread(tg , "tg组的线程甲");
        tt.start();

        new MyThread(tg , "tg组的线程乙").start();
    }

    static class MyThread extends Thread {
        public MyThread(ThreadGroup group, String name) {
            super(group, name);
        }

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println(getName()+" 线程i变量："+i);
            }
        }
    }
}
