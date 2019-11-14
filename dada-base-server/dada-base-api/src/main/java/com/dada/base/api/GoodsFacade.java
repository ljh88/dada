package com.dada.base.api;

import com.dada.base.common.DataResponse;
import com.dada.base.common.MessageResponse;
import com.dada.base.common.PageInfo;
import com.dada.base.common.PageInfoResponse;
import com.dada.base.service.GoodsEntity;

/**
 * @Description：商品接口
 * @author: lijinghua
 * @Date: 2019/9/12
 */
public interface GoodsFacade {

    /**
     * 新增商品信息
     * @param goodsEntity
     * @return
     */
    MessageResponse addGoodsInfo(GoodsEntity goodsEntity);

    /**
     * 更新商品信息
     * @param goodsEntity
     * @return
     */
    MessageResponse updateGoodsInfo(GoodsEntity goodsEntity);

    /**
     * 查询商品信息分页
     * @param goodsEntity
     * @return
     */
    PageInfoResponse<GoodsEntity> queryGoodsInfoList(GoodsEntity goodsEntity, PageInfo pageInfo);

    /**
     * 查询商品信息
     * @param goodsEntity
     * @return
     */
    DataResponse<GoodsEntity> queryGoodsInfo(GoodsEntity goodsEntity);
}
