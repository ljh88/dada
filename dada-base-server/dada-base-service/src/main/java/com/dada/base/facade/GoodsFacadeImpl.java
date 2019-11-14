package com.dada.base.facade;

import com.dada.base.api.GoodsFacade;
import com.dada.base.common.DataResponse;
import com.dada.base.common.MessageResponse;
import com.dada.base.common.PageInfo;
import com.dada.base.common.PageInfoResponse;
import com.dada.base.exception.BaseException;
import com.dada.base.exception.ValidateException;
import com.dada.base.service.GoodsEntity;


import com.dada.base.service.GoodsService;
import com.dada.base.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Description：商品接口服务
 * @author: lijinghua
 * @Date: 2019/9/12
 */
@Service
public class GoodsFacadeImpl implements GoodsFacade {

    private static Logger LOGGER = LoggerFactory.getLogger(GoodsFacadeImpl.class);

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private Validator<GoodsEntity> validator;

    @Override
    public MessageResponse addGoodsInfo(GoodsEntity goodsEntity) {
        MessageResponse response = new MessageResponse();
        try {
            validator.isEmpty(goodsEntity);
            LOGGER.info("addGoodsInfo 请求，request: ", goodsEntity);
            goodsService.addGoodsInfo(goodsEntity);
        }catch(ValidateException e){
            LOGGER.error("#addGoodsInfo 异常, e: ", e);
            response.setResponseCode(e.getCode());
            response.setResponseDesc(e.getDesc());
        }catch(BaseException e) {
            LOGGER.error("#addGoodsInfo 异常, e: ", e);
            response.setResponseCode(e.getCode());
            response.setResponseDesc(e.getDesc());
        }
        return response;
    }

    @Override
    public MessageResponse updateGoodsInfo(GoodsEntity goodsEntity) {
        MessageResponse response = new MessageResponse();
        try {
            validator.isEmpty(goodsEntity);
            LOGGER.info("updateGoodsInfo 请求，request: ", goodsEntity);
            goodsService.updateGoodsInfo(goodsEntity);
        }catch(ValidateException e){
            LOGGER.error("#updateGoodsInfo 异常, e: ", e);
            response.setResponseCode(e.getCode());
            response.setResponseDesc(e.getDesc());
        }catch(BaseException e) {
            LOGGER.error("#updateGoodsInfo 异常, e: ", e);
            response.setResponseCode(e.getCode());
            response.setResponseDesc(e.getDesc());
        }
        return response;
    }

    @Override
    public PageInfoResponse<GoodsEntity> queryGoodsInfoList(GoodsEntity goodsEntity , PageInfo pageInfo) {
        PageInfoResponse<GoodsEntity> response = new PageInfoResponse<GoodsEntity>();
        try {
            PageInfo<GoodsEntity> entityPageInfo = new PageInfo<GoodsEntity>(pageInfo.getPageNum(), pageInfo.getPageSize());
            LOGGER.info("queryGoodsInfoList 请求，request: ", goodsEntity);
            entityPageInfo = goodsService.queryGoodsInfoList(goodsEntity,pageInfo);
            response.setPageInfo(entityPageInfo);
        }catch(BaseException e) {
            LOGGER.error("#queryGoodsInfoList 异常, e: ", e);
            response.setResponseCode(e.getCode());
            response.setResponseDesc(e.getDesc());
        }
        return response;
    }

    @Override
    public DataResponse<GoodsEntity> queryGoodsInfo(GoodsEntity goodsEntity) {
        DataResponse<GoodsEntity> response = new DataResponse<GoodsEntity>();
        try {
            GoodsEntity entity = new GoodsEntity();
            LOGGER.info("queryGoodsInfo 请求，request: ", goodsEntity);
            entity = goodsService.queryGoodsInfo(goodsEntity);
            response.setData(entity);
        }catch(BaseException e) {
            LOGGER.error("#queryGoodsInfo 异常, e: ", e);
            response.setResponseCode(e.getCode());
            response.setResponseDesc(e.getDesc());
        }
        return response;
    }
}
