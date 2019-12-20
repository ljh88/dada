package com.dada.rpc;

import com.alibaba.dubbo.rpc.RpcException;
import com.dada.base.api.DemoFacade;
import com.dada.base.dto.GoodsDto;
import com.dada.base.response.DataResponse;
import com.dada.base.response.PageInfo;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description：商品配置
 * @author: lijinghua
 * @Date: 2019/9/25
 */
@Service
public class DemoHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(DemoFacade.class);

    @Autowired
    private DemoFacade demoFacade;

    public DataResponse<PageInfo<GoodsDto>>  queryGoodsLists(GoodsDto goodsDto, Page page){
        try{
            DataResponse<PageInfo<GoodsDto>> response = demoFacade.queryGoodsInfoList(goodsDto, page);
            return response;
        }catch (Exception e){
            LOGGER.error("#queryGoods e", e);
            throw new RpcException(RpcException.NETWORK_EXCEPTION);
        }
    }
    public DataResponse<GoodsDto> queryGoodsInfo(GoodsDto goodsDto){
        try{
            DataResponse<GoodsDto> response = demoFacade.queryGoodsInfo(goodsDto);
            if(response == null){
                LOGGER.error("#queryGoodsInfo, response", response);
            }
            return response;
        }catch (Exception e){
            LOGGER.error("#queryGoods e", e);
            throw new RpcException(RpcException.NETWORK_EXCEPTION);
        }
    }


}
