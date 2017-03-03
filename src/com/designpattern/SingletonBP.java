package com.designpattern;

/**
 * Created by hexi on 17-2-20.
 * 单例模式的最佳实践，jvm的懒加载模式
 */
public class SingletonBP {
    public static class Singleton {
        private Singleton() {
//            throw new RuntimeException("Stub");
        }

        private static class SingletonContainer {
            // 17-2-21修改，加上volatile变量，对volatile变量的写操作HB于后面对这个变量的读操作
            private volatile static Singleton instance = new Singleton();
        }

        public static Singleton getInstance() {
            return SingletonContainer.instance;
        }
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }
}
