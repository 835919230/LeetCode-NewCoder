package com.classdemo;

import com.common.ListNodeFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by hexi on 17-1-24.
 */
public class ClassDemo {
    public static void main(String[] args) {
        Class<ListNodeFactory> listNodeFactoryClass = ListNodeFactory.class;
        Method[] methods = listNodeFactoryClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("---------------------------");
        for (Method method : listNodeFactoryClass.getDeclaredMethods()) {
            System.out.print(method.getName()+" parameters:");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getName()+","+parameter.getType());
            }
            System.out.print("\n");
        }
    }
}
