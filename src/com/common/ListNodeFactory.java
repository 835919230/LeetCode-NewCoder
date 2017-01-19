package com.common;

/**
 * Created by HeXi on 2017/1/19.
 */
public class ListNodeFactory {
    private ListNodeFactory() {
    }

    private static ListNodeFactory instance;

    public static ListNodeFactory getInstance() {
        if (instance == null) {
            synchronized (ListNodeFactory.class) {
                if (instance == null) {
                    instance = new ListNodeFactory();
                }
            }
        }

        return instance;
    }

    public static ListNode create(int val) {
        return new ListNode(val);
    }

    public static ListNode create() {
        return create(-1);
    }
}
