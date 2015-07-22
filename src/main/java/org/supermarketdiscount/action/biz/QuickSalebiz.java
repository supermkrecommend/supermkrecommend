package org.supermarketdiscount.action.biz;

/**
 * Created by Administrator on 2015/5/7.
 */
public class QuickSalebiz {
    private boolean isquickSale;
    private String description;
    public QuickSalebiz(boolean isquickSale){
        this.setIsquickSale(isquickSale);
        if(isquickSale){
            this.setDescription("快消");
        }else{
            this.setDescription("非快消");
        }

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsquickSale() {

        return isquickSale;
    }
    public boolean isquickSale() {

        return isquickSale;
    }

    public void setIsquickSale(boolean isquickSale) {
        this.isquickSale = isquickSale;
    }
}
