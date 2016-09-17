/**
 * Created by 诚 on 2016/9/10.
 */
public class NotInit {

    {
        System.out.println("");
    }

    private String baseName = "base";

    public NotInit() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    static class Sub extends NotInit {
        private String baseName = "Sub";

        public Sub() {
        }

        @Override
        public void callName() {
            System.out.println(this.baseName);
        }
    }


    public static void main(String[] args) {
//        System.out.println(SubClass.value); //只出现了SuperClass Init 并输出value的值
//    SuperClass[] sus = new SuperClass[10];    //什么输出都没有
//        System.out.println(ConstClass.HELLO_WORLD); //只出现 HELLO_WORLD的值，没有出现静态代码块的内容
//        System.out.println(10%3*2);
//        NotInit b = new Sub();//null
        Integer var1 = new Integer(1);
        Integer var2 = var1;
        doSomething(var2);
        System.out.println(var1 == var2);
        System.out.println(var1.intValue());
        Object obj = new Object(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(obj.equals("123"));
    }

    private static void doSomething(Integer var2) {
        var2 = new Integer(2);
    }
}

abstract class Animal{
    abstract void say();
}