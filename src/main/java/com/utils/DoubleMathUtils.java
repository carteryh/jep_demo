//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lz.utils.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class DoubleMathUtils {
    public DoubleMathUtils() {
    }

    public static double round(double value, int scale, RoundingMode roundingMode) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(scale, roundingMode);
        double d = bd.doubleValue();
        bd = null;
        return d;
    }

    public static double round(double value, int scale) {
        return round(value, scale, RoundingMode.HALF_EVEN);
    }

    public static double round(double value) {
        return round(value, 2);
    }

    public static String format(double value) {
        value = round(value);
        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        return format.format(value).replaceAll(",", "");
    }

    public static void main(String[] args) {
        double a = ceil(0.0D, 100.0D);
        System.out.println((int)a);
    }

    public static double sum(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).setScale(2, 4).doubleValue();
    }

    public static double sub(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).setScale(2, 4).doubleValue();
    }

    public static double mul(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).setScale(2, 4).doubleValue();
    }

    public static double div(double d1, double d2, int scale) {
        if (d2 == 0.0D) {
            return 0.0D;
        } else {
            BigDecimal bd1 = new BigDecimal(Double.toString(d1));
            BigDecimal bd2 = new BigDecimal(Double.toString(d2));
            return bd1.divide(bd2, scale, 4).doubleValue();
        }
    }

    public static int div(double d1, double d2) {
        if (d2 == 0.0D) {
            return 0;
        } else {
            BigDecimal bd1 = new BigDecimal(Double.toString(d1));
            BigDecimal bd2 = new BigDecimal(Double.toString(d2));
            BigDecimal result = bd1.divide(bd2, RoundingMode.DOWN);
            return result.intValue();
        }
    }

    public static Long toLongCurr(Double price) {
        price = mul(price, 100.0D);
        return price.longValue();
    }

    public static double ceil(double d1, double precision) {
        return Math.ceil(d1 / precision) * precision;
    }

    public static double floor(double d1, double precision) {
        return Math.floor(d1 / precision) * precision;
    }

    public static double trunc(int c, double precision, double d1) {
        double result = 0.0D;
        switch(c) {
            case 0:
                result = round(d1, 0);
                break;
            case 1:
                result = ceil(d1, precision);
                break;
            case 2:
                result = floor(d1, precision);
                break;
            default:
                result = floor(d1, 100.0D);
        }

        return result;
    }

    public static double killNullToZero(Double d1) {
        return d1 == null ? 0.0D : d1;
    }

    public static int compare(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.compareTo(b2);
    }
}
