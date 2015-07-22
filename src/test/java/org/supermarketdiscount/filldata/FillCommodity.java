package org.supermarketdiscount.filldata;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.BrandMapper;
import org.junit.Test;
import org.supermarketdiscount.dao.CommodityMapper;
import org.supermarketdiscount.entity.Brand;
import org.supermarketdiscount.entity.Commodity;

import java.io.File;

/**
 * Created by Administrator on 2015/5/16.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class FillCommodity extends AbstractJUnit4SpringContextTests {
    @Test
    public void fill() throws Exception{
        Workbook book  =  Workbook.getWorkbook(new File("F:\\supermarketDate.xls "));
        //  获得第一个工作表对象
        Sheet sheet  =  book.getSheet( 2 );
        //  得到第一列第一行的单元格
        int rows = sheet.getRows();
        Commodity commodity = new Commodity();
        String temp = null;
        int add = 0;
        for(int i = 1; i < rows ; i++) {
            if(!sheet.getCell(16,i).getContents().trim().isEmpty()){
                add = 4;
            }else if(!sheet.getCell(15,i).getContents().trim().isEmpty()){
                add = 3;
            }else
            if(!sheet.getCell(14,i).getContents().trim().isEmpty()){
                add = 2;
            }else if(sheet.getCell(13,i).getContents().trim().isEmpty()){
                add = 0 ;
            }else{
                add = 1;
            }
            temp = sheet.getCell(12+add, i).getContents();
            if(temp.matches("[0-9]+")){
                commodity.setBrandid(Long.parseLong(temp));
            }else{
                commodity.setBrandid(0);
            }

            commodity.setCommodityName(sheet.getCell(2+add, i).getContents());
            commodity.setQualification(sheet.getCell(3+add, i).getContents());
            commodity.setManufacture(sheet.getCell(5+add, i).getContents());
            commodity.setIsquickSale(true);
            temp = sheet.getCell(7+add, i).getContents();
            if(temp.matches("^\\d+(\\.\\d+)?$")){
                commodity.setBasePrice(Double.parseDouble(temp));
            }else{
                commodity.setBasePrice(0.0);
            }
            temp = sheet.getCell(0, i).getContents();
            if(temp.matches("[0-9]+")){
                commodity.setCommodityid(Long.parseLong(temp));
            }else{
                commodity.setCommodityid(0);
            }
            commodity.setShapeCode(sheet.getCell(11+add, i).getContents());
            temp = sheet.getCell(1, i).getContents();
            if(temp.matches("[0-9]+")){
                commodity.setEncode(Long.parseLong(temp));
            }else{
                commodity.setEncode(0);
            }
            commodity.setQualification(sheet.getCell(3+add, i).getContents());
            commodity.setIsPromotion(false);
            commodity.save();
        }
    }
}