package com.dada.base.api;

import com.dada.base.common.DataResponse;
import com.dada.base.common.MessageResponse;
import com.dada.base.common.PageInfo;
import com.dada.base.common.PageInfoResponse;
import com.dada.base.dto.GoodsDto;

/**
 * @Description：商品接口
 * @author: lijinghua
 * @Date: 2019/9/12
 */
public interface GoodsFacade {

    /**
     * 新增商品信息
     * @param goods
     * @return
     */
    MessageResponse addGoodsInfo(GoodsDto goods);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    MessageResponse updateGoodsInfo(GoodsDto goods);

    /**
     * 查询商品信息分页
     * @param goods
     * @return
     */
    PageInfoResponse<GoodsDto> queryGoodsInfoList(GoodsDto goods, PageInfo pageInfo);

    /**
     * 查询商品信息
     * @param goods
     * @return
     */
    DataResponse<GoodsDto> queryGoodsInfo(GoodsDto goods);
}
