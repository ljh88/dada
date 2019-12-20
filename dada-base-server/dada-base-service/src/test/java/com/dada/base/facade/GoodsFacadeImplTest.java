package com.dada.base.facade;


import com.dada.base.common.DataResponse;
import com.dada.base.common.MessageResponse;
import com.dada.base.common.PageInfo;
import com.dada.base.common.PageInfoResponse;
import com.dada.base.service.BaseTest;
import com.dada.base.service.GoodsEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @Description：
 * @author: lijinghua
 * @Date: 2019/9/16
 */
public class GoodsFacadeImplTest extends BaseTest {

    @Autowired
    private GoodsFacadeImpl goodsFacade;

    @Test
    public void addGoodsInfo() {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsName("Ipad");
        goodsEntity.setGoodsSku(System.currentTimeMillis()+"");
        goodsEntity.setGoodsNum(2);
        goodsEntity.setGoodsPrice(10000L);
        goodsEntity.setIsMarketable("Y");
        MessageResponse response = goodsFacade.addGoodsInfo(goodsEntity);
        System.out.println(response);
    }

    @Test
    public void updateGoodsInfo() {
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setGoodsName("Ipad");
        goodsEntity.setGoodsSku(System.currentTimeMillis()+"");
        goodsEntity.setGoodsNum(2);
        goodsEntity.setGoodsPrice(10000L);
        goodsEntity.setIsMarketable("Y");
        MessageResponse response = goodsFacade.updateGoodsInfo(goodsEntity);
        System.out.println(response);
    }

    @Test
    public void queryGoodsInfoList() {
        PageInfoResponse pageInfoResponse = goodsFacade.queryGoodsInfoList(new GoodsEntity(), new PageInfo());
        System.out.println(pageInfoResponse);

    }

    @Test
    public void queryGoodsInfo() {
        DataResponse<GoodsEntity> response = new DataResponse<GoodsEntity>();
        GoodsEntity goodsEntity = new GoodsEntity();
        goodsEntity.setId(1);
        response = goodsFacade.queryGoodsInfo(goodsEntity);
        System.out.println(response);

    }
}