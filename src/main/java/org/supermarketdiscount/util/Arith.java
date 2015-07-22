package org.supermarketdiscount.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 由于Java的简单类型不能够精确的对浮点数进行运算，这个工具类提供精
 * 确的浮点数运算，包括加减乘除和四舍五入。
 */
@Service("arith")
@Scope("singleton")
public class Arith {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 5;

    //这个类不能实例化
    private Arith() {
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return round(b1.add(b2).doubleValue(), 5);
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return round(b1.subtract(b2).doubleValue(), 5);
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return round(b1.multiply(b2).doubleValue(), 5);
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后5位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return round(div(v1, v2, DEF_DIV_SCALE), 5);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {

        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double doubleRound(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 向下取整，1。9变为1
     * @param v 需要取整的数字
     * @return 取整结果
     */
    public static Integer doubleFloor(double v){
        return  new BigDecimal(v).intValue();
    }
    /**
     * 进行随机，判断结果
     *
     * @param odds 概率
     * @return 结果
     */
    public static boolean oddsResult(double odds) {
        boolean result = true;
        Random r = new Random();
        BigDecimal odd = new BigDecimal(odds);
        BigDecimal random = new BigDecimal(r.nextInt(100));
        if (odd.compareTo(random) == -1) {
            result = false;
        }
        return result;
    }

    /**
     * 得到不重复的number个书，最大可能值为size
     * size 要大于 number
     *
     * @param size   候选数组大小
     * @param number 需要选出的数量
     * @return
     */
    public static List<Integer> getSingleList(int size, int number) {
        Random r = new Random();
        List<Integer> list = new ArrayList<Integer>();
        r.nextInt();
        for (int i = 0; i < number; i++) {
            Integer value = null;
            do {
                value = r.nextInt(size);
            } while (list.contains(value));
            list.add(value);
        }
        return list;
    }

};