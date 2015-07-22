package org.supermarketdiscount.filldata;

import jxl.Sheet;
import jxl.Workbook;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.entity.Brand;
import org.supermarketdiscount.entity.CommodityType;

import java.io.File;

/**
 * Created by Administrator on 2015/5/16.
 */

@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class FillCommodityType extends AbstractJUnit4SpringContextTests {
    @Test
    public void fill()throws Exception{
            Workbook book  =  Workbook.getWorkbook(new File("F:\\supermarketDate.xls "));
            //  获得第一个工作表对象
            Sheet sheet  =  book.getSheet( 1 );
            //  得到第一列第一行的单元格
            int rows = sheet.getRows();
            CommodityType type = new CommodityType();
            for(int i = 1027; i < rows ; i++){
                type.setTypeName(sheet.getCell(1, i).getContents().trim());
                type.setTypeid(Integer.parseInt(sheet.getCell(0, i).getContents()));
                type.save();
            }
            book.close();
    }
}