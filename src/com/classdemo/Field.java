package com.classdemo;

/**
 * Created by hexi on 17-1-29.
 */
public class Field {
    public static void main(String[] args) {
        FieldTrouble ft = new FieldTrouble();
        Class<? extends FieldTrouble> c = ft.getClass();
        try {
            java.lang.reflect.Field f = c.getDeclaredField("val");
//            f.setInt(ft, 42); Illegal
            f.setInt(ft, 1);
            System.out.println(f.getType());
            System.out.println(f.get(ft));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static class FieldTrouble {
        int val;
    }
}
