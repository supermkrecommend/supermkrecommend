package org.supermarketdiscount.RandomTest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jxl.Workbook;
import jxl.write.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.supermarketdiscount.dao.CommodityMapper;
import org.supermarketdiscount.dao.PurchaseHistoryMapper;
import org.supermarketdiscount.entity.Commodity;
import org.supermarketdiscount.entity.DiscountStandard;
import org.supermarketdiscount.entity.PurchaseHistory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Administrator on 2015/5/18.
 */
@ContextConfiguration(locations = { "classpath:org/config/spring/testApplicationContext.xml" })
public class TestWriteExcel extends AbstractJUnit4SpringContextTests {
    @Autowired
    private PurchaseHistoryMapper mapper;

    @Test
    public void fill() throws Exception {
        WritableWorkbook book = Workbook.createWorkbook(new File(" test.xls "));
        //  生成名为“第一页”的工作表，参数0表示这是第一页
        WritableSheet sheet = book.createSheet(" 第一页 ", 0);
        int pageCoun = 100;
        int currentPage = 1;
        int number = 0;
        PageHelper.startPage(currentPage, 200);
        DateFormat customDateFormat = new DateFormat("yyyy/MM/dd");
        WritableCellFormat dateFormat = new WritableCellFormat(customDateFormat);
        List<PurchaseHistory> list = mapper.getPurchaseHistoryList(null);
        PageInfo page = new PageInfo(list);
        pageCoun = page.getPages();
        DiscountStandard standard = new DiscountStandard();
        for (; currentPage < pageCoun+1; currentPage++) {
            PageHelper.startPage(currentPage, 200);
            list = mapper.getPurchaseHistoryList(null);
            for(PurchaseHistory history : list){
                sheet.addCell( new  jxl.write.Number( 0 ,  number ,  history.getSerialNumber() ));
                sheet.addCell( new  jxl.write.Number( 1 ,  number ,  history.getUserid() ));
                sheet.addCell( new  jxl.write.Number( 2 ,  number , 1 ));
                sheet.addCell(new DateTime(3, number, history.getShortDate(), dateFormat));
                sheet.addCell( new  jxl.write.Number( 4 ,  number ,  history.getCommodityid() ));
                sheet.addCell( new  jxl.write.Number( 5 ,  number ,  history.getCounts() ));
                sheet.addCell( new  jxl.write.Number( 6 ,  number ,  history.getSalsePrice() ));
                sheet.addCell( new  jxl.write.Number( 7 ,  number ,  history.getCountPrice() ));
                number++;
            }
        }

        //  写入数据并关闭文件
        book.write();
        book.close();
    }
}