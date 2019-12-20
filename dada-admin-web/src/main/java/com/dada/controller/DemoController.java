package com.dada.controller;

import com.dada.base.common.ApiConstants;
import com.dada.base.dto.GoodsDto;
import com.dada.base.response.ApiResponse;
import com.dada.base.response.DataResponse;
import com.dada.base.response.PageInfo;
import com.dada.rpc.DemoHandler;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description：商品配置
 * @author: lijinghua
 * @Date: 2019/9/26
 */
@RequestMapping("/test")
@Controller
public class DemoController {

    private static Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoHandler demoHandler;


    /**
     * 查询商品列表
     * @param goodsDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse queryGoodsList(@RequestParam(required = false)GoodsDto goodsDto, @RequestParam(required = false)Integer pageNum, @RequestParam(required = false)Integer pageSize){

        Page page = new Page(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
        DataResponse<PageInfo<GoodsDto>> response = new DataResponse<>();
        try{
            response = demoHandler.queryGoodsLists(goodsDto, page);
        }catch (Exception e){
            LOGGER.error("queryGoodsList error", e);
            response.setCode(ApiConstants.SYSTEM_ERROR);
            response.setMsg("服务异常");
        }
        return DataResponse.newDataResponse(response);
    }

    /**
     * 查询商品
     * @param goodsDto
     * @return
     */
    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse  queryGoods(@RequestParam(required = false)GoodsDto goodsDto){

        DataResponse<GoodsDto> dataRes = new DataResponse<>();
        try{
            dataRes = demoHandler.queryGoodsInfo(goodsDto);
        }catch (Exception e){
            LOGGER.error("queryGoodsList error", e);
            dataRes.setCode("0");
            dataRes.setMsg("服务异常");
        }
        return DataResponse.newDataResponse(dataRes);
    }



}
