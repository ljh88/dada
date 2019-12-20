package com.dada.base.api;

import com.dada.base.dto.GoodsDto;
import com.dada.base.response.DataResponse;
import com.dada.base.response.PageInfo;
import com.github.pagehelper.Page;

/**
 * @Description：商品接口
 * @author: lijinghua
 * @Date: 2019/9/12
 */
public interface DemoFacade {


    /**
     * 分页查询所有商品信息
     * @param goodsDto
     * @param page
     * @return
     */
    DataResponse<PageInfo<GoodsDto>> queryGoodsInfoList(GoodsDto goodsDto, Page page);


    /**
     * 查询商品信息
     * @param goodsDto
     * @return
     */
    DataResponse<GoodsDto> queryGoodsInfo(GoodsDto goodsDto);

}
