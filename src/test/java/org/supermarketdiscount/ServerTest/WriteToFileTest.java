package org.supermarketdiscount.ServerTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.server.WriteToFile;
import org.junit.Test;

/**
 * Created by Administrator on 2015/6/3.
 */
public class WriteToFileTest {
    @Test
    public void testWriteToFile(){
        WriteToFile.alterUser("测试添加信息srfgsfdg");
    }
}