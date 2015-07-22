package org.supermarketdiscount.filldata;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.BrandMapper;
import org.junit.Test;
import org.supermarketdiscount.entity.Brand;

import java.io.File;

/**
 * Created by Administrator on 2015/5/16.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class FillBrand extends AbstractJUnit4SpringContextTests {
    @Test
    public void fill()throws Exception{
            Workbook book  =  Workbook.getWorkbook(new File("F:\\supermarketDate.xls "));
            //  获得第一个工作表对象
            Sheet sheet  =  book.getSheet( 0 );
            //  得到第一列第一行的单元格
            int rows = sheet.getRows();
            Brand brand = new Brand();
            for(int i = 1; i < rows ; i++){
                brand.setBrandName(sheet.getCell(1,i).getContents());
                brand.setBrandid(Long.parseLong(sheet.getCell(0, i).getContents()));
                brand.save();
            }
            book.close();
    }
}