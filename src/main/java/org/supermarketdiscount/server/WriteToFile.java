package org.supermarketdiscount.server;

import java.io.*;

/**
 * 可以认为是发送信息，只是现在是以文本的形式保存。
 */
public class WriteToFile {
    private static String promotionfilePath = "D://促销价格信息.txt";
    private static String alterfilePaht = "D://提醒购买信息.txt";
    private static String forecastMessageFilePath = "D://预测购买信息.txt";
    public static void sendPromotionMessage(String content ){
        witeToFile(content,promotionfilePath);
    }
    public static void alterUser(String content){
        witeToFile(content,alterfilePaht);
    }
    public static void forecastMessage(String content){
        witeToFile(content,forecastMessageFilePath);
    }
    private static void witeToFile(String content , String filePath){
        try {
            File f = null;
                f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();// 不存在则创建
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(content);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}