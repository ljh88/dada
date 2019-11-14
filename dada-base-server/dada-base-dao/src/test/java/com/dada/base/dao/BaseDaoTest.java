package com.dada.base.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description：测试基类
 * @author: lijinghua
 * @Date: 2019/9/11
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mybatis/mybatis-config.xml", "classpath:spring/applicationContext-dao.xml" })
public class BaseDaoTest {
    @Test
    public void insert(){

        System.out.println("a");

    }
}
