package com.dada.base.service;

import com.dada.base.common.PageInfo;
import com.dada.base.dto.GoodsDto;
import com.dada.base.enums.ErrorCode;
import com.dada.base.exception.BaseException;
import com.dada.base.model.Goods;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dada.base.mapper.GoodsMapper;

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
    private GoodsMapper goodsMapper;

    public void addGoodsInfo(Goods goods) throws BaseException {
        try {
            goodsMapper.insert(goods);
        } catch (Exception e) {
            LOGGER.error("addGoodsInfo errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
    }

    public void updateGoodsInfo(Goods goods) throws BaseException {
        try {
            goodsMapper.update(goods);
        } catch (Exception e) {
            LOGGER.error("updateGoodsInfo errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
    }

    public GoodsDto queryGoodsInfo(GoodsDto goods) throws BaseException {
        GoodsDto good = new GoodsDto();
        try {
            good = goodsMapper.selectGoods(goods);
        } catch (Exception e) {
            LOGGER.error("queryGoodsInfo errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
        return goods;
    }
    public com.dada.base.response.PageInfo<Goods> queryGoodsInfoLists(Goods goods, PageInfo pageInfo) throws BaseException {
        List<Goods> goodsList = null;
        com.dada.base.response.PageInfo<Goods> PageInfo = new com.dada.base.response.PageInfo<Goods>();
        try {
            pageInfo = pageInfo == null ? new PageInfo() : pageInfo;
            Page<Goods> page = startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            goodsList = goodsMapper.selectBy(goods);
            PageInfo.setList(goodsList);
            PageInfo.setTotal(page.getTotal());
        } catch (Exception e) {
            LOGGER.error("queryGoodsInfoList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
        return PageInfo;
    }
    public PageInfo<Goods> queryGoodsInfoList(Goods goods, PageInfo pageInfo) throws BaseException {
        List<Goods> goodsList = null;
        PageInfo<Goods> PageInfo = new PageInfo<Goods>(pageInfo.getPageNum(), pageInfo.getPageSize());
        try {
            pageInfo = pageInfo == null ? new PageInfo() : pageInfo;
            Page<Goods> page = startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
            goodsList = goodsMapper.selectBy(goods);
            PageInfo.setList(goodsList);
            PageInfo.setTotal(page.getTotal());
        } catch (Exception e) {
            LOGGER.error("queryGoodsInfoList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
        return PageInfo;
    }

    public List<String> queryGoodsNameList() throws BaseException {
        List<String> goodsNameList = new ArrayList<>();
        try {
            goodsNameList = goodsMapper.selectGoodsNameList();
        } catch (Exception e) {
            LOGGER.error("queryGoodsNameList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);        }
        return goodsNameList;
    }
    public List<String> queryGoodsSkuList() throws BaseException {
        List<String> goodsSkuList = new ArrayList<>();
        try {
            goodsSkuList = goodsMapper.selectGoodsSkuList();
        } catch (Exception e) {
            LOGGER.error("queryGoodsNameList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);        }
        return goodsSkuList;
    }
}

