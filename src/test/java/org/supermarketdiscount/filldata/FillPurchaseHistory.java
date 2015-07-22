package org.supermarketdiscount.filldata;

import jxl.CellType;
import jxl.DateCell;
import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.entity.PurchaseHistory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/5/16.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class FillPurchaseHistory extends AbstractJUnit4SpringContextTests {
    @Test
    public void fill() throws Exception {
        Workbook book = Workbook.getWorkbook(new File("F:\\supermarketDate.xls "));
        Sheet sheet = null;
        for (int sheetNum = 3; sheetNum < 6; sheetNum++) {
            sheet = book.getSheet(sheetNum);
            int rows = sheet.getRows();
            int userNumber = 1;
            PurchaseHistory history = new PurchaseHistory();
            DateCell dc = null;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd ");
            for (int i = 1; i < rows; i++) {
                if(userNumber > 600){
                    userNumber = userNumber - 600;
                }else{
                    userNumber ++;
                }
                history.setCommodityid(Long.parseLong(sheet.getCell(5, i).getContents()));
                history.setCounts(Math.abs(Double.parseDouble(sheet.getCell(6, i).getContents())));
                history.setStoreNumber(1019);
                dc = (DateCell) sheet.getCell(3, i);
                history.setShortDate(dc.getDate());
                history.setCountPrice(Math.abs(Double.parseDouble(sheet.getCell(8, i).getContents())));
                history.setSalsePrice(Double.parseDouble(sheet.getCell(7, i).getContents()));
                history.setUserid(userNumber);
                history.save();
            }
        }
    }
}