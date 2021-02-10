package com.dada.base.dao;

import com.dada.base.mapper.SellerMapper;
import com.dada.base.model.Seller;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description：
 * @author: lijinghua
 * @Date: 2019/9/12
 */
public class SellerMapperTest extends BaseDaoTest{

    @Autowired
    private SellerMapper sellerMapper;

    @Test
    public void insert() {
        Seller seller = new Seller();
        seller.setSellerId("123");
        seller.setSellerName("特步旗舰店");
        int result = sellerMapper.insert(seller);
    }

    @Test
    public void update() {
        Seller seller = new Seller();
        seller.setSellerId("123");
        seller.setSellerName("珀莱雅官方旗舰店");
        int result = sellerMapper.update(seller);
        System.out.println(result);
    }

    @Test
    public void selectBy() {
        Seller seller = new Seller();
        List<Seller> list = sellerMapper.selectBy(seller);
        System.out.println(list);
    }

}