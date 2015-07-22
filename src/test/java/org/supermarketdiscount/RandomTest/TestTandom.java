package org.supermarketdiscount.RandomTest;
import org.junit.Test;

import java.util.Random;

/**
 * Created by Administrator on 2015/5/8.
 */
public class TestTandom {
    @Test
    public void testClassName(){
        String className = this.getClass().getName();
        String can = this.getClass().getCanonicalName();
        String simple = this.getClass().getSimpleName();
        System.out.println(className);
        System.out.println(can);
        System.out.println(simple);
    }
    public String getClassSimpleName(){
       return this.getClass().getSimpleName();
    }
    @Test
    public  void rand(){
        Random r = new Random();
        for(int i = 1 ; i < 5; i++){
            System.out.println(r.nextInt(20));
        }
    }
}
