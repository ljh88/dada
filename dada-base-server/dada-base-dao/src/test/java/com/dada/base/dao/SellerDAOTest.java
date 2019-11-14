package com.dada.base.dao;

import com.dada.base.service.SellerEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description：
 * @author: lijinghua
 * @Date: 2019/9/12
 */
public class SellerDAOTest extends BaseDaoTest{

    @Autowired
    private SellerDao sellerDao;

    @Test
    public void insert() {
        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setSellerId("123");
        sellerEntity.setSellerName("特步旗舰店");
        int result = sellerDao.insert(sellerEntity);
    }

    @Test
    public void update() {
        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setSellerId("123");
        sellerEntity.setSellerName("珀莱雅官方旗舰店");
        int result = sellerDao.update(sellerEntity);
        System.out.println(result);
    }

    @Test
    public void selectBy() {
        SellerEntity sellerEntity = new SellerEntity();
        List<SellerEntity> list = sellerDao.selectBy(sellerEntity);
        System.out.println(list);
    }

}