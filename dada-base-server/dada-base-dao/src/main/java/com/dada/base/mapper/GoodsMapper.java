package com.dada.base.mapper;

import com.dada.base.dto.GoodsDto;
import com.dada.base.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GoodsMapper extends BaseDao<Integer, Goods> {

    List<String> selectGoodsNameList();

    List<String> selectGoodsSkuList();

    List<GoodsDto> selectGoodsList(GoodsDto entity);

    GoodsDto selectGoods(GoodsDto entity);

}