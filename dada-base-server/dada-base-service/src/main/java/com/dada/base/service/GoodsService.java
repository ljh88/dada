package com.dada.base.service;

import com.dada.base.common.PageInfo;
import com.dada.base.enums.ErrorCode;
import com.dada.base.exception.BaseException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dada.base.dao.GoodsDao;

import java.util.ArrayList;
import java.util.List;

import static com.github.pagehelper.PageHelper.*;

/**
 * @Description：商品
 * @author: lijinghua
 * @Date: 2019/9/12
 */

@Service
public class GoodsService {

    private static Logger LOGGER = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    private GoodsDao goodsDao;

    public void addGoodsInfo(GoodsEntity goodsEntity) throws BaseException {
        try {
            goodsDao.insert(goodsEntity);
        } catch (Exception e) {
            LOGGER.error("addGoodsInfo errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
    }

    public void updateGoodsInfo(GoodsEntity goodsEntity) throws BaseException {
        try {
            goodsDao.update(goodsEntity);
        } catch (Exception e) {
            LOGGER.error("updateGoodsInfo errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
    }

    public GoodsEntity queryGoodsInfo(GoodsEntity goodsEntity) throws BaseException {
        GoodsEntity goods = new GoodsEntity();
        try {
            goods = goodsDao.selectEntity(goodsEntity);
        } catch (Exception e) {
            LOGGER.error("queryGoodsInfo errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
        return goods;
    }
    public com.dada.base.response.PageInfo<GoodsEntity> queryGoodsInfoLists(GoodsEntity goodsEntity, PageInfo pageInfo) throws BaseException {
        List<GoodsEntity> goodsEntityList = null;
        com.dada.base.response.PageInfo<GoodsEntity> entityPageInfo = new com.dada.base.response.PageInfo<GoodsEntity>();
        try {
            pageInfo = pageInfo == null ? new PageInfo() : pageInfo;
            Page<GoodsEntity> page = startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            goodsEntityList = goodsDao.selectBy(goodsEntity);
            entityPageInfo.setList(goodsEntityList);
            entityPageInfo.setTotal(page.getTotal());
        } catch (Exception e) {
            LOGGER.error("queryGoodsInfoList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
        return entityPageInfo;
    }
    public PageInfo<GoodsEntity> queryGoodsInfoList(GoodsEntity goodsEntity, PageInfo pageInfo) throws BaseException {
        List<GoodsEntity> goodsEntityList = null;
        PageInfo<GoodsEntity> entityPageInfo = new PageInfo<GoodsEntity>(pageInfo.getPageNum(), pageInfo.getPageSize());
        try {
            pageInfo = pageInfo == null ? new PageInfo() : pageInfo;
            Page<GoodsEntity> page = startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            goodsEntityList = goodsDao.selectBy(goodsEntity);
            entityPageInfo.setList(goodsEntityList);
            entityPageInfo.setTotal(page.getTotal());
        } catch (Exception e) {
            LOGGER.error("queryGoodsInfoList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
        return entityPageInfo;
    }

    public List<String> queryGoodsNameList() throws BaseException {
        List<String> goodsNameList = new ArrayList<>();
        try {
            goodsNameList = goodsDao.selectGoodsNameList();
        } catch (Exception e) {
            LOGGER.error("queryGoodsNameList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);        }
        return goodsNameList;
    }
    public List<String> queryGoodsSkuList() throws BaseException {
        List<String> goodsSkuList = new ArrayList<>();
        try {
            goodsSkuList = goodsDao.selectGoodsSkuList();
        } catch (Exception e) {
            LOGGER.error("queryGoodsNameList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);        }
        return goodsSkuList;
    }
}

