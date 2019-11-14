<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String thisUrl = request.getServletPath();
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">

    <title><decorator:title default="渠道运营后台"/></title>

    <link rel="stylesheet" href="/plugins/bootstrap-v3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <link href="/plugins/select2/select2.min.css" rel="stylesheet" type="text/css">

    <script src="/plugins/select2/select2.full.js" type="text/javascript"></script>
    <script src="/plugins/metisMenu/dist/metisMenu.min.js"></script>
    <script src="/js/select2Ext.js?v=a5368d3e8f" type="text/javascript"></script>
    <script src="/js/common.js" type="text/javascript"></script>
    <script src="/plugins/pinyin/index.js"></script>
    <decorator:head/>
</head>

<body>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-showside">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href=""><img src="//storage.jd.com/static.nj.com/new-logo.png"
                                                 width="164" height="36" alt="京东金融"></a>
        </div>
        <!-- Top Menu Items -->
        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> 欢迎您
                    <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <rbac:hasPermissions name="link:report">
                    <li>
                        <a href="http://nmgt.jd.com/mgt/report/index"><i class="fa fa-fw fa-external-link"></i> 报表平台</a>
                    </li>
                    </rbac:hasPermissions>
                    <li>
                        <a href="/logout"><i class="fa fa-fw fa-power-off"></i> 登出</a>
                    </li>
                </ul>
            </li>
        </ul>
        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <div class="navbar-sideholder"></div>
            <ul class="nav navbar-nav side-nav" id="side-menu">
                <li class="sidebar-search" style="float: none;">
                    <div class="custom-search-form">
                        <select id="side-search" class="form-control" >
                            <option id="default-search" selected="selected"></option>
                        </select>
                    </div>
                    <!-- /input-group -->
                </li>
                <rbac:hasPermissions name="person">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>人员管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="person:area_manager">
                                <li><a href="/yy/manage/areaContactManagement" data-menu="p_area_manager">区域负责人管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="person:area_supervisor">
                                <li><a href="/yy/manage/areaManagerManagement" data-menu="p_area_supervisor">区域主管管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="person:label">
                                <li><a href="/yy/audit/auditManageIndex" data-menu="p_label">人员标签管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="person:operator">
                                <li><a href="/manage/person/index" data-menu="p_operator">人员区域管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="person:channel_staff_info">
                                <li><a href="/yy/manage/channelStaffBasicInfo/index" data-menu="p_channel_staff_info">渠道人员基础信息管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="person:channel_train_info">
                                <li><a href="/yy/manage/channelStaffTrainingInfo/index" data-menu="p_channel_train_info">渠道人员培训信息管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="person:channel_staff_performance">
                                <li><a href="/yy/manage/channelStaffPerformance/index" data-menu="p_channel_staff_performance">渠道人员绩效信息管理</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="customer">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>用户管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="company:business_license">
                                <li><a href="/yy/manage/businessLicense" data-menu="c_user">营业执照号查询</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:partner_customer">
                                <li><a href="/contract/easyshop/promoterCustomerIndex" data-menu="c_partner_customer">上下级关系管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:station_merchant">
                                <li><a href="/config/merchantConfig/index" data-menu="c_station_merchant">站主商户号管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:customer_value">
                                <li><a href="/yy/manage/customerValueInfoIndex" data-menu="c_customer_value">下线用户价值查询</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:user">
                                <li><a href="/yy/manage/promoterDetailIndex" data-menu="c_user">用户明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:first_order">
                                <li><a href="/contract/easyshop/jdCustomerIndex" data-menu="c_first_order">用户首单信息查询</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:recruit">
                                <li><a href="/yy/manage/applyManage" data-menu="c_recruit">招募管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:recruit_info">
                                <li><a href="/yy/manager/recruit/index" data-menu="c_recruit_info">招募信息查询</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:user_distribute">
                                <li><a href="/yy/manage/userDistribution" data-menu="c_user_distribute">用户分布报表</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="customer:partner_sign">
                                <li><a href="/statistics/financing/promoterSignDetail" data-menu="c_partner_sign">合伙人签约统计</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="station">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>金融小站<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="station:address">
                                <li><a href="/yy/manage/xzChooseAddress" data-menu="s_address">金融小站选址</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:map">
                                <li><a href="https://api-nj.jd.com/ncjr_static/heatMap/heatMap.html" data-menu="s_map">金融小站地图</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:factors">
                                <li><a href="/yy/manage/stationMustInit" data-menu="s_factors">新建小站六必须统计</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:factors">
                                <li><a href="/yy/manage/continueModelStationIndex" data-menu="s_factors">连续标杆统计</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:convenient_service">
                                <li><a href="/yy/manage/convenientServiceInfoIndex" data-menu="s_convenient_service">便民自提点</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:app_download">
                                <li><a href="/yy/manage/appDownloadIndex" data-menu="s_app_download">金融小站APP下载统计</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:statistic">
                                <li><a href="/yy/manage/promoterFinancialDetailIndex" data-menu="s_statistic">金融小站月度数据</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:statistic_partner">
                                <li><a href="/yy/manage/promoterFinancialDetailIndexPartner" data-menu="s_statistic_parent">金融小站合伙人月度数据</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:statistic_area">
                                <li><a href="/yy/manage/promoterFinancialCountyDetailIndex" data-menu="s_statistic_area">金融小站经济圈月度数据</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:statistic_open">
                                <li><a href="/yy/manage/promoterDailyStatIndex" data-menu="s_statistic_open">金融小站激活数据</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="station:coupon">
                                <li><a href="/yy/manage/coupon/index" data-menu="s_coupon">小站有礼</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="channel">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>合作渠道管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="channel:company">
                                <li><a href="/yy/manage/channelManagement" data-menu="ch_company">合作渠道商户管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="channel:fee">
                                <li><a href="/yy/manage/channelMonthManagement" data-menu="ch_fee">合作渠道业绩管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="channel:statistic">
                                <li><a href="/yy/manage/channelInfoStatistics/index" data-menu="ch_statistic">渠道信息统计</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="merchant">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>商户平台管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="merchant:company">
                                <li><a href="/merchant/index" data-menu="mer_company">商家招募管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="merchant:goods">
                                <li><a href="/merchant/goods/index" data-menu="mer_goods">物料商品管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="merchant:order">
                                <li><a href="/merchant/order/index" data-menu="mer_order">商家订单管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="merchant:settle">
                                <li><a href="/merchant/settle/index" data-menu="mer_settle">商家结算管理</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="market">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>营销功能<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="market:online_resource">
                                <li><a href="/yy/market/onlineResourceIndex" data-menu="m_online_resource">线上营销资源位管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="market:offline_resource">
                                <li><a href="/yy/market/offlineResourceIndex" data-menu="m_offline_resource">线下营销资源位管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="market:promoter_offline_resource">
                                <li><a href="/promoter/manage/marketResourceManageIndex" data-menu="m_p_offline_resource">主管线下营销资源位管理</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="cobrandedcard">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>联名卡管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="cobrandedcard:manage">
                                <li><a href="/yy/manage/cobrandedcardIndex" data-menu="cbc_manage">联名卡卡面管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="cobrandedcard:apply">
                                <li><a href="/yy/manage/coCardApplyIndex" data-menu="cbc_apply">联名卡申请管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="cobrandedcard:flow">
                                <li><a href="/yy/manage/coCardDetailNaturalIndex" data-menu="cbc_flow">联名卡自然流量</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="jdunion">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>网络联盟<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="jdunion:directory">
                                <li><a href="/client/yypz/jdUnionCategoryIndex" data-menu="ju_directory">网络联盟目录树管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="jdunion:sort">
                                <li><a href="/client/yypz/jdUnionSortIndex" data-menu="ju_sort">网络联盟目录排序设置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="jdunion:rakeback_rate">
                                <li><a href="/client/yypz/jdUnionRakebackIndex" data-menu="ju_rakeback_rate">网络联盟商品分成设置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="jdunion:order">
                                <li><a href="/statistics/jdunion/toIndex" data-menu="ju_order">联盟商品订单明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="jdunion:order">
                                <li><a href="/statistics/jdunion/orderData/toIndex" data-menu="ju_order_data">联盟订单数据看板</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="jdunion:merchant">
                                <li><a href="/client/yypz/jdUnionMerchant/index" data-menu="ju_merchant">联盟商家优选商品管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="jdunion:plan">
                                <li><a href="/client/yypz/jdunion/plan/index" data-menu="ju_plan">联盟京推计划</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="product">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>产品管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="product:product_lib_config">
                                <li><a href="/client/clientProductLibConfig/index" data-menu="pr_product_lib_config">产品库分类配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="product:product_lib">
                                <li><a href="/client/yypz/clientProductLib/index" data-menu="pr_product_lib">产品库配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="product:country_lib">
                                <li><a href="/client/yypz/clientCountryLib/index" data-menu="pr_country_lib">恋乡村产品信息配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="product:goods">
                                <li><a href="/contract/goods/goodsCollectionIndex" data-menu="pr_goods">商流商品配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="product:client_activity">
                                <li><a href="/contract/clientActivityLibrary/index" data-menu="pr_client">拉新活动配置</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="order">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>产品订单管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="order:jd_order">
                                <li><a href="/jrxz/station/rfRakebackGoodsInfo/index" data-menu="o_jd_order">商流商品订单明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="order:crow_order">
                                <li><a href="/jrxz/station/rfRakebackCrowInfo/index" data-menu="o_crow_order">众筹订单明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="order:best_sell_order">
                                <li><a href="/jrxz/station/bestSellOrder/index" data-menu="o_jd_order">今日特卖订单数据统计</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="order:replenishment">
                                <li><a href="/jrxz/dev/deviveredOrders/index" data-menu="o_replenishment">妥投商品补单</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="order:risk_order">
                                <li><a href="/jrxz/station/riskOrder/index">风险订单查询</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="order:cz_order_address">
                                <li><a href="/jrxz/station/czOrderAddress/index" data-menu="o_cz_order">出众订单物流地址信息</a></li>
                            </rbac:hasPermissions>

                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="promotion">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>产品推广<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="promotion:kdb">
                                <li><a href="/contract/easyshop/kdbOperationDetail" data-menu="pro_kdb">开店宝二期操作明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:pull_new">
                                <li><a href="/contract/easyshop/pullNewRecordsIndex" data-menu="pro_pull_new">拉新记录查询</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:insure">
                                <li><a href="/jrxz/station/pacx/index" data-menu="pro_insure">平安车险数据导入</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:qqnews_week">
                                <li><a href="/jrxz/station/qqnews/week/index" data-menu="pro_qqnews_week">腾讯新闻周数据导入</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:qqnews_month">
                                <li><a href="/jrxz/station/qqnews/month/index" data-menu="pro_qqnews_month">腾讯新闻月度数据导入</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:vip_order">
                                <li><a href="/yy/manage/vipOrderGoodsInfoIndex" data-menu="pro_vip_order">唯品会订单明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:jr_app_download">
                                <li><a href="/contact/manage/financing/appDownload" data-menu="pro_jr_app_download">金融APP下载明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:auth">
                                <li><a href="/statistics/auth/toIndex" data-menu="pro_auth">实名活动页数据统计</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:open">
                                <li><a href="/statistics/open/bizFirst/index" data-menu="pro_auth">激活记录数据统计</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:jutu">
                                <li><a href="/jrxz/station/jutunet/index" data-menu="pro_jutu">聚土网数据查看</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:bt_active">
                                <li><a href="/baitiao/log/index" data-menu="pro_bt_active">乡白激活流水</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:recommend">
                                <li><a href="/labor/laborRecommend/index" data-menu="pro_recommend">劳务推荐</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="promotion:rebate_card">
                                <li><a href="/yy/manage/RebateCard/index" data-menu="pro_rebate_card">京粉卡返佣</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="commission">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>佣金管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="commission:config">
                                <li><a href="/contract/rakebackManager/rakebackIndex" data-menu="co_config">分佣配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="commission:insure">
                                <li><a href="/contract/insureRakebackManager/insureRakebackIndex" data-menu="co_insure">内部车险分佣配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="commission:manual">
                                <li><a href="/commission/manual/repairCommission" data-menu="co_manual">人工补发佣金</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="commission:audit_manual">
                                <li><a href="/commission/approve/manual/approveCommission" data-menu="co_audit_manual">审核人工补发佣金</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="commission:manage">
                                <li><a href="/contract/easyshop/clearFlowIndex" data-menu="co_manage">返佣信息管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="commission:batch_manage">
                                <li><a href="/commission/batch/batchManage" data-menu="co_batch_manage">佣金批量管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="commission:withdraw">
                                <li><a href="/yy/manager/withdraw/index" data-menu="co_withdraw">提现记录查询</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="commission:overview">
                                <li><a href="/yy/manage/toStatisticChartsIndex" data-menu="co_overview">佣金总览</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="app">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>小站应用配置<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="app:client_all_config">
                                <li><a href="/client/yypz/clientAllConfig/index" data-menu="app_client_all_config">功能应用配置管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:shuffling">
                                <li><a href="/client/yypz/clientShuffling/index" data-menu="app_shuffling">客户端轮播配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:train_type">
                                <li><a href="/client/clientLearnConfig/index" data-menu="app_train_type">在线培训类型配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:train_info">
                                <li><a href="/client/yypz/clientLearnInfo/index" data-menu="app_train_info">在线培训信息配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:promotion_product">
                                <li><a href="/client/yypz/promotionProductDesc/index" data-menu="app_promotion_product">推广产品说明</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:market">
                                <li><a href="/client/yypz/clientMarketingLib/index" data-menu="app_market">聚合营销信息配置-活动中心</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:sms_config">
                                <li><a href="/client/yypz/clientSmsConfig/index" data-menu="app_sms_config">客户推广短信配置-通讯录</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:commission_product">
                                <li><a href="/jrxz/station/finConfig/finConfigIndex" data-menu="app_commission_product">返佣产品配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:notice">
                                <li><a href="/jrxz/station/jrStationNotice/index" data-menu="app_notice">工作台公告编辑</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:msg_center">
                                <li><a href="/jrxz/station/msgCenterConfig/index" data-menu="app_msg_center">消息中心配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:portalshuffling">
                                <li><a href="/jrcppz/portalshuffling/index" data-menu="app_portalshuffling">首焦轮播配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:portalfinancial">
                                <li><a href="/jrcppz/portalfinancial/index" data-menu="app_portalfinancial">专属理财配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:product_config">
                                <li><a href="/jrcppz/productConfig/index" data-menu="app_product_config">金融小站产品配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:poster">
                                <li><a href="/client/yypz/posterShareConfig/index" data-menu="app_poster">分享海报配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:help">
                                <li><a href="/client/yypz/appHelptext/index" data-menu="app_help">小站帮助说明配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:sell">
                                <li><a href="/client/yypz/bestSell/index" data-menu="app_sell">今日特卖产品配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:task_release">
                                <li><a href="/yy/manage/taskRelease/index" data-menu="app_task_release">任务中心管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:task_claim">
                                <li><a href="/yy/manage/taskClaim" data-menu="app_task_audit">任务领取明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:rights_config">
                                <li><a href="/yy/manage/rightsConfig/index" data-menu="app_rights_config">兑换中心管理</a> </li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:rights_exchange">
                                <li><a href="/yy/manage/rightsExchange/index" data-menu="app_rights_exchange">兑换订单明细</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:client_version">
                                <li><a href="/client/clientVersion/index" data-menu="app_client_version">小站APP版本配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="app:client_config">
                                <li><a href="/client/clientConfig/index" data-menu="app_client_config">小站APP配置</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="config">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>配置管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="config:whitelist">
                                <li><a href="/yy/manage/rfPersonWhitelist" data-menu="conf_whitelist">白名单管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:supplier">
                                <li><a href="/jrxz/station/merchantInfo/index" data-menu="conf_supplier">供应商信息维护</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:biztype">
                                <li><a href="/contract/easyshop/biztypeIndex" data-menu="conf_biztype">业务类型管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:fincost">
                                <li><a href="/contract/easyshop/finConf/list" data-menu="conf_fincost">财务费用编号配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:contract">
                                <li><a href="/contract/contractTemplate/list" data-menu="conf_contract">合同模板管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:contract_type">
                                <li><a href="/contract/contractType/list" data-menu="conf_contract_type">合同类型管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:source">
                                <li><a href="/config/sourcePlatform/index" data-menu="conf_source">来源配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:switch">
                                <li><a href="/config/switch/index" data-menu="conf_switch">开关配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:btwhitelist">
                                <li><a href="/config/iouWhitelist/index" data-menu="conf_btwhitelist">白条白名单配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:data_cache">
                                <li><a href="/config/dataCenterConfig/index" data-menu="conf_data_cache">数据中心缓存配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:kepler_token">
                                <li><a href="/contract/easyshop/tokenConfigIndex" data-menu="conf_kepler_token">令牌配置</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:area_address">
                                <li><a href="/areaAddress/index" data-menu="conf_area_address">区域地址映射管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="config:general">
                                <li><a href="/common/config/index" data-menu="conf_area_address">通用配置管理</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="query">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>日常查询<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="query:account_opening_status">
                                <li><a href="/contract/easyshop/cofferAccountIndex" data-menu="q_account_opening_status">小金库开户状态查询</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="query:account_pocket_money">
                                <li><a href="/contract/easyshop/queryXjkConsumeBalanceIndex" data-menu="q_account_pocket_money">小金库零用钱查询</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
                <rbac:hasPermissions name="data">
                    <li class="active">
                        <a href="#"><i class="fa fa-edit fa-fw"></i>数据管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <rbac:hasPermissions name="data:invoice">
                                <li><a href="/yy/manage/invoiceAccountManagement" data-menu="d_invoice">益世发票代开管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="data:opinion">
                                <li><a href="/contract/easyshop/suggestionIndex" data-menu="d_opinion">意见建议信息管理</a></li>
                            </rbac:hasPermissions>
                            <rbac:hasPermissions name="data:smart_shelf">
                                <li><a href="/yy/manage/smartShelfIndex" data-menu="d_smart_shelf">智能货架数据总览</a></li>
                            </rbac:hasPermissions>
                        </ul>
                    </li>
                </rbac:hasPermissions>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div id="page-wrapper">

        <div class="container-fluid">
            <!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">
                    <ol class="breadcrumb">
                        <li>
                            <i class="fa fa-home"></i> <a href="/">首页</a>
                        </li>
                        <li class="active">
                            <decorator:title/>
                        </li>
                    </ol>
                </div>
            </div>
            <!-- /.row -->
            <decorator:body/>
        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<footer class="footer">
    <div class="container">
        <p class="text-muted"> Powered By ncrd@jd.com</p>
    </div>
</footer>
</body>

</html>