/*
 * @(#) a 2018/10/30 18:11
 *
 * Copyright 2018 JDJR All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * Author Email: lijinghua3@jd.com
 */
package com.dada.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

/**
 * 小站有礼
 *
 * @author lijinghua3
 * @create 2018/10/29
 * @since 1.0.0
 */
@RequestMapping("/yy/manage/coupon")
@Controller
public class StationCouponController {



    @RequestMapping("index")
    public ModelAndView index(HttpServletRequest httpServletRequest) {
        ModelAndView mv = new ModelAndView("a");
        String queryStartDate = httpServletRequest.getParameter("queryStartDate");
        String queryEndDate = httpServletRequest.getParameter("queryEndDate");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return mv;
    }


}
