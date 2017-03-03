import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by hexi on 16-10-16.
 */
public class ForkAndJoin {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random(47);
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = random.nextInt(20);
            total += (arr[i] = tmp);
        }
        System.out.println(total);

        ForkJoinPool pool = ForkJoinPool.commonPool();

        ForkJoinTask<Integer> submit = pool.submit(new CalTask(arr, 0, arr.length));
        while (!submit.isDone());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    static class CalTask extends RecursiveTask<Integer> {

        private static final int THRESHOLD = 20;

        private int[] arr;

        private int start;
        private int end;

        public CalTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            if (end- start < THRESHOLD) {
                for (int i = start; i < end; i++) {
                    sum+=arr[i];
                }
                return sum;
            } else {
                int middle = (start + end) / 2;
                CalTask left = new CalTask(arr, start, middle);
                CalTask right = new CalTask(arr, middle, end);
                left.fork();
                right.fork();
                return left.join()+right.join();
            }
        }
    }
}
