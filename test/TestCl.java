/**
 * Created by hexi on 17-2-5.
 */
public class TestCl {
    public static void main(String[] args) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (i % 6 == 1 && i % 5 == 2 && i % 4 == 3 && i % 3 == 0)
                System.out.println(i);
        }
    }
}
