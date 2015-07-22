package org.supermarketdiscount.RandomTest;
import org.junit.Test;
import org.supermarketdiscount.util.Arith;
import org.supermarketdiscount.util.DateGenerator;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2015/6/13.
 */
public class TestDateGenerator {
    @Test
    public void testgetDateBefore() throws Exception{
        Date date = DateGenerator.getDate("1990-1-1");
        date = DateGenerator.getDateBefore(date,5);
        System.out.println(date);
    }
    @Test
    public void testMath(){
        System.out.println( new BigDecimal(1.9).intValue());
    }
    @Test
    public void toDouble(){
        Integer a = Integer.valueOf(12);
       double b = a.floatValue();
    }
    @Test
    public void testcalculateNextPurchaseDate() throws Exception{
        System.out.println(this.calculateNextPurchaseDate(DateGenerator.getDate("1990-1-1"),1.2,2));
    }
    private static Date calculateNextPurchaseDate(Date currentDate , Double consumeDay,Integer count){
        return  DateGenerator.getDateBefore(currentDate, Arith.doubleFloor(Arith.mul(consumeDay, count.floatValue())));
    }
}
