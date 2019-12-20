package com.dada.base.facade;

import com.dada.base.api.DemoFacade;
import com.dada.base.common.ApiConstants;
import com.dada.base.dto.GoodsDto;
import com.dada.base.response.DataResponse;
import com.dada.base.response.PageInfo;
import com.dada.base.service.DemoService;
import com.dada.base.service.GoodsEntity;
import com.dada.base.util.Validator;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description：商品接口服务
 * @author: lijinghua
 * @Date: 2019/9/12
 */
@Service
public class DemoFacadeImpl implements DemoFacade {

    private static Logger LOGGER = LoggerFactory.getLogger(DemoFacadeImpl.class);

    @Autowired
    private DemoService testService;

    @Autowired
    private Validator<GoodsEntity> validator;


    /**
     * 商品列表
     * @param goodsDto
     * @param page
     * @return
     */
    @Override
    public DataResponse<PageInfo<GoodsDto>> queryGoodsInfoList(GoodsDto goodsDto, Page page) {
        DataResponse<PageInfo<GoodsDto>> response = new DataResponse<>();
        try {
            LOGGER.info("queryGoodsInfoList 请求，request: ", goodsDto);
            PageInfo<GoodsDto> entityPageInfo = testService.queryGoodsInfoLists(goodsDto, page);
            response.setData(entityPageInfo);
        } catch (Exception e) {
            LOGGER.error("#queryGoodsInfoList 异常, e: ", e);
            response.setCode(ApiConstants.SYSTEM_ERROR);
            response.setMsg(ApiConstants.SYSTEM_ERROR_MSG);
            response.setException(e.getMessage());
        }
        return response;
    }

    /**
     * 查询商品详情
     * @param goodsDto
     * @return
     */
    @Override
    public DataResponse<GoodsDto> queryGoodsInfo(GoodsDto goodsDto) {
        DataResponse<GoodsDto> response = new DataResponse<>();
        try {
            LOGGER.info("queryGoodsInfo 请求，request: ", goodsDto);
            GoodsDto dto = testService.queryGoodsInfo(goodsDto);
            response.setData(dto);
        } catch (Exception e) {
            LOGGER.error("#queryGoodsInfo 异常, e: ", e);
            response.setCode(ApiConstants.SYSTEM_ERROR);
            response.setMsg(ApiConstants.SYSTEM_ERROR_MSG);
            response.setException(e.getMessage());
        }
        return response;
    }


}
