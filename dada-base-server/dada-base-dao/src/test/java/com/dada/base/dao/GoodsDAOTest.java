package com.dada.base.dao;

import com.dada.base.service.GoodsEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Description：
 * @author: lijinghua
 * @Date: 2019/9/11
 */
public class GoodsDAOTest extends BaseDaoTest{

    @Autowired
    private GoodsDao goodsDAO;

    @Test
    public void insert() {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsName("Ipad");
        goodsEntity.setGoodsSku(System.currentTimeMillis()+"");
        goodsEntity.setGoodsNum(2);
        goodsEntity.setGoodsPrice(10000L);
        goodsEntity.setIsMarketable("Y");
        int result = goodsDAO.insert(goodsEntity);
        System.out.println(result);
//        Assert.assertEquals(1, result);
    }

    @Test
    public void update() {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setId(5);
        goodsEntity.setGoodsName("珀莱雅面膜");
        int result = goodsDAO.update(goodsEntity);
        System.out.println(result);
    }

    @Test
    public void selectBy() {
        GoodsEntity goodsEntity = new GoodsEntity();
        List<GoodsEntity> list = goodsDAO.selectBy(goodsEntity);
        System.out.println(list);
    }

}