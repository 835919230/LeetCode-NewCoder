package com.sword;

/**
 * Created by 诚 on 2016/9/10.
 * 求一个double数值的n次方
 */
public class Power {
    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1d;
        if (exponent == 1)
            return base;
        int exp = exponent < 0 ? -exponent : exponent;
        double newBase = exponent < 0 ? 1d/base : base;
        double rel = Power(newBase,exp/2);
        if ((exp & 1) == 1)//如果是奇数
            return rel*rel*newBase;
        else return rel*rel;
    }

    public static void main(String[] args) {
        System.out.println(Power(2.5d,4));
    }
}
