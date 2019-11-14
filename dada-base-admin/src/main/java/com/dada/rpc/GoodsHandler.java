package com.dada.rpc;

import com.alibaba.dubbo.rpc.RpcException;
import com.dada.base.api.GoodsFacade;
import com.dada.base.common.DataResponse;
import com.dada.base.common.MessageResponse;
import com.dada.base.common.PageInfo;
import com.dada.base.common.PageInfoResponse;
import com.dada.base.service.GoodsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description：商品配置
 * @author: lijinghua
 * @Date: 2019/9/25
 */
@Service
public class GoodsHandler {

    private static Logger LOGGER = LoggerFactory.getLogger(GoodsHandler.class);

    @Autowired
    private GoodsFacade goodsFacade;

    public PageInfoResponse<GoodsEntity> queryGoodsList(GoodsEntity goodsEntity, PageInfo pageInfo){
        try{
            PageInfoResponse<GoodsEntity> response = goodsFacade.queryGoodsInfoList(goodsEntity, pageInfo);
            if(response == null){
                LOGGER.error("#queryGoodsList, response", response);
            }
            return response;
        }catch (Exception e){
            LOGGER.error("#queryGoods e", e);
            throw new RpcException(RpcException.NETWORK_EXCEPTION);
        }
    }

    public DataResponse<GoodsEntity> queryGoods(GoodsEntity goodsEntity){
        try{
            DataResponse<GoodsEntity> response = goodsFacade.queryGoodsInfo(goodsEntity);
            if(response == null){
                LOGGER.error("#queryGoods, response", response);
            }
            return response;
        }catch (Exception e){
            LOGGER.error("#queryGoods e", e);
            throw new RpcException(RpcException.NETWORK_EXCEPTION);
        }
    }

    public MessageResponse addGoods(GoodsEntity goodsEntity){
        try{
            MessageResponse response = goodsFacade.addGoodsInfo(goodsEntity);
            if(response == null){
                LOGGER.error("#addGoods, response", response);
                throw new RpcException(RpcException.NETWORK_EXCEPTION);
            }
            return response;
        }catch (Exception e){
            LOGGER.error("#addGoods, e", e);
            throw new RpcException(RpcException.NETWORK_EXCEPTION);
        }
    }

    public void updateGoods(GoodsEntity goodsEntity){
        try{
            MessageResponse response = goodsFacade.updateGoodsInfo(goodsEntity);
            if(response == null){
                LOGGER.error("#updateGoods, response", response);
                throw new RpcException(RpcException.NETWORK_EXCEPTION);
            }
        }catch (Exception e){
            LOGGER.error("#addGoods, e", e);
            throw new RpcException(RpcException.NETWORK_EXCEPTION);
        }
    }

}
