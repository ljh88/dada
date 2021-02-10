package com.dada.base.service;

import com.dada.base.mapper.GoodsMapper;
import com.dada.base.dto.GoodsDto;
import com.dada.base.enums.ErrorCode;
import com.dada.base.exception.BaseException;
import com.dada.base.response.PageInfo;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.pagehelper.PageHelper.startPage;

/**
 * @Description：商品
 * @author: lijinghua
 * @Date: 2019/9/12
 */

@Service
public class DemoService {

    private static Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    private GoodsMapper goodsMapper;


    public PageInfo<GoodsDto> queryGoodsInfoLists(GoodsDto goodsDto, Page page) throws BaseException {
        PageInfo<GoodsDto> entityPageInfo = new PageInfo<>();
        try {
            page = page == null ? new Page(10,1) : page;
            Page<GoodsDto> pageInfo = startPage(page.getPageNum(), page.getPageSize());
            List<GoodsDto> goodsEntityList = goodsMapper.selectGoodsList(goodsDto);
            entityPageInfo.setList(goodsEntityList);
            entityPageInfo.setTotal(pageInfo.getTotal());
            return entityPageInfo;
        } catch (Exception e) {
            LOGGER.error("queryGoodsInfoList errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
    }
    public GoodsDto queryGoodsInfo(GoodsDto goodsDto) throws BaseException {
        try {
            GoodsDto goods = goodsMapper.selectGoods(goodsDto);
            return goods;
        } catch (Exception e) {
            LOGGER.error("queryGoodsInfo errror: ", e);
            throw new BaseException(ErrorCode.DATABASE_ERROR);
        }
    }

}

