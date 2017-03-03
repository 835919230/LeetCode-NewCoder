import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by hexi on 16-10-15.
 */
public class DynamicProxy {
    public static void main(String[] args) throws IOException, InterruptedException {
//        inter before = (inter) Proxy.newProxyInstance(inter.class.getClassLoader(),
//                                                        new Class[]{inter.class},
//                                                        new DynamicProxyHandler(new implmenttation()));
//        before.doSomething();
//        before.doAnotherthing();
//
//        File file = new File("src/com/common");
//        if (file.exists() && file.isDirectory())
//        {
//            File[] files = file.listFiles();
//            for (File fi : files)
//                System.out.println(fi);
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = 0; i < 100; i++) {
//            executorService.execute(new Provider());
//        }
//        for (int i = 0; i < 100; i++) {
//            executorService.execute(new Consumer());
//        }
//        executorService.execute(new Provider());
//        executorService.execute(new Provider());
//        executorService.execute(new Provider());
//        executorService.execute(new Provider());
//
//        int i = 0;
//
//        executorService.execute(new Consumer());
//        executorService.execute(new Consumer());
//        executorService.execute(new Consumer());
//        executorService.execute(new Consumer());
//        executorService.execute(new Consumer());
//        executorService.execute(new Provider());

        Callable<Integer[]> callable = new PrimeCallable(1000);
//        FutureTask<Integer[]> primeTask = new FutureTask<Integer[]>(callable);
//        Thread thread = new Thread(primeTask);
//        thread.start();

        Future<Integer[]> submit = executorService.submit(callable);


        try {
//            Thread.sleep(5000);
            while (!submit.isDone());
            if (submit.isDone()) {
                Integer[] integers = submit.get();
                for (Integer integer : integers) {
                    System.out.println(integer);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class PrimeCallable implements Callable<Integer[]> {

        private int max;

        public PrimeCallable(int max) {
            this.max = max;
        }

        @Override
        public Integer[] call() throws Exception {
            int[] prime = new int[max+1];

            for (int i = 0; i < prime.length; i++) {
                prime[i] = 1;
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 2; i <= max; i++) {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0)
                        prime[i] = 0;
                }
            }

            for (int i = 2; i < prime.length; i++) {
                if (prime[i] == 1)
                    list.add(i);
            }
            return list.toArray(new Integer[0]);
        }
    }

    static PriorityBlockingQueue<Integer> blockingQueue = new PriorityBlockingQueue<>();

    static Random random = new Random(47);

    static class Provider implements Runnable {
        @Override
        public void run() {
            int i = random.nextInt(100);
            blockingQueue.add(i);
            System.out.println("生产者放入了："+i);
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                Integer take = blockingQueue.remove();
                System.out.println("消费者消费了："+take);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    interface inter {
        void doSomething();
        void doAnotherthing();
    }

    static class implmenttation implements inter {

        @Override
        public void doSomething() {
            System.out.println("doSomething");
        }

        @Override
        public void doAnotherthing() {
            System.out.println("doAntherthing");
        }
    }

    //JDK动态代理
    static class DynamicProxyHandler implements InvocationHandler {
        private Object proxied;

        public DynamicProxyHandler(Object o) {
            this.proxied = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            return method.invoke(proxied, args);
        }
    }
}
