package com.dada.base.dao;

import com.dada.base.dto.GoodsDto;
import com.dada.base.service.GoodsEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GoodsDao extends BaseDao<Integer, GoodsEntity> {

    List<String> selectGoodsNameList();

    List<String> selectGoodsSkuList();

    List<GoodsDto> selectGoodsList(GoodsDto entity);

    GoodsDto selectGoods(GoodsDto entity);

}