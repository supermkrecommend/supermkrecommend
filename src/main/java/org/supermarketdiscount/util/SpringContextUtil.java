package org.supermarketdiscount.util;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


@Service("SpringContextUtil")
public class SpringContextUtil implements ApplicationContextAware {


    private static ApplicationContext applicationContext;


    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    public static Object getBean(String beanId) throws BeansException {
        return applicationContext.getBean(beanId);
    }

    public static Map<String, Integer> getDataSourceStats() throws SQLException {
        BasicDataSource dataSource = (BasicDataSource) SpringContextUtil.getBean("dataSource");
        Map<String, Integer> map = new HashMap<String, Integer>(2);
        map.put("active_number", dataSource.getNumActive());
        map.put("idle_number", dataSource.getNumIdle());
        System.out.println("active_number:" + dataSource.getNumActive());
        System.out.println("idle_number:" + dataSource.getNumIdle());
        return map;
    }


}