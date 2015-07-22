package org.supermarketdiscount.ServerTest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.junit.Test;
import org.supermarketdiscount.server.MessageServer;
import org.supermarketdiscount.util.DateGenerator;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Administrator on 2015/6/3.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class MessageServerTest extends AbstractJUnit4SpringContextTests {
    @Test
    public void sendPromotionMessageTest() throws ParseException {
        Date date = DateGenerator.getDate("2010-3-4");
        MessageServer server = new MessageServer();
        server.sendPromotionMessage(date);
    }
    @Test
    public void sendForecastCommidityMessageTest()throws ParseException {
        Date date = DateGenerator.getDate("2010-3-4");
        MessageServer server = new MessageServer();
        server.forecastCommidityMessage(date);
    }
}