package com.dada.base.dao;

import com.dada.base.mapper.GoodsMapper;
import com.dada.base.model.Goods;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description：
 * @author: lijinghua
 * @Date: 2019/9/11
 */
public class GoodsMapperTest extends BaseDaoTest{

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void insert() {
        Goods goods = new Goods();
        goods.setGoodsName("Ipad");
        goods.setGoodsSku(System.currentTimeMillis()+"");
        goods.setGoodsNum(2);
        goods.setGoodsPrice(10000L);
        goods.setIsMarketable("Y");
        int result = goodsMapper.insert(goods);
        System.out.println(result);
//        Assert.assertEquals(1, result);
    }

    @Test
    public void update() {
        Goods goods = new Goods();
        goods.setId(5);
        goods.setGoodsName("珀莱雅面膜");
        int result = goodsMapper.update(goods);
        System.out.println(result);
    }

    @Test
    public void selectBy() {
        Goods goods = new Goods();
        List<Goods> list = goodsMapper.selectBy(goods);
        System.out.println(list);
    }

}