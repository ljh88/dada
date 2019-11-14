package com.dada.controller;

import com.dada.base.common.BaseResponse;
import com.dada.base.common.PageInfo;
import com.dada.base.common.PageInfoResponse;
import com.dada.base.enums.ErrorCode;
import com.dada.base.service.GoodsEntity;
import com.dada.rpc.GoodsHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description：商品配置
 * @author: lijinghua
 * @Date: 2019/9/26
 */
@RequestMapping("/goods")
@Controller
public class GoodsController {

    private static Logger LOGGER = LoggerFactory.getLogger(GoodsController.class);

    @Autowired
    private GoodsHandler goodsHandler;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("goods");
        return modelAndView;
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageInfo queryGoodsList(GoodsEntity goodsEntity,Integer pageNum, Integer pageSize){
        PageInfo pageInfo = new PageInfo(pageNum, pageSize);
        try{
            PageInfoResponse<GoodsEntity> pageInfoResponse = goodsHandler.queryGoodsList(goodsEntity, pageInfo);
            pageInfo = pageInfoResponse.getPageInfo();
        }catch (Exception e){
            LOGGER.error("queryGoodsList error", e);
        }
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/addorEdit")
    public BaseResponse addOrEditGoods(GoodsEntity goodsEntity){
        BaseResponse baseResponse = new BaseResponse();
        try{
            if(goodsEntity.getId() != null && goodsEntity.getId() != 0){
                goodsHandler.updateGoods(goodsEntity);
                baseResponse.buildSuccessResponse("更新成功");
            }else{
                goodsHandler.addGoods(goodsEntity);
                baseResponse.buildSuccessResponse("添加成功");
            }
            baseResponse.buildSuccessResponse();
        }catch (Exception e){
            LOGGER.error("#addOrEditGoods 异常:", e);
            baseResponse.buildServerErrorResponse(ErrorCode.UNKNOWN_ERROR.getCode(),ErrorCode.UNKNOWN_ERROR.getDesc());
        }
        return baseResponse;
    }

}
