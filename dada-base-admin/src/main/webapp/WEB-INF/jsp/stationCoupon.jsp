<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小站有礼</title>
    <script type="text/javascript" src="/plugins/jqGrid/js/i18n/grid.locale-cn.js"></script>
    <script type="text/javascript" src="/plugins/jqGrid/js/jquery.jqGrid.min.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="/plugins/jqGrid/css/ui.jqgrid-bootstrap.css" />
    <link href="/plugins/datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src="/plugins/datetimepicker/bootstrap-datetimepicker.js" type="text/javascript"></script>
    <script src="/plugins/datetimepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    <script src="//storage.jd.com/static.nj.com/js/cxSelect1.4.2/jquery.cxselect.js" type="text/javascript"></script>
    <!-- production -->
    <script src="/js/jqGridExt.js?v=726ffaf36e"></script>
</head>
<body>
<%--加载表格--%>
<div class="row">
    <div class="col-lg-12">
        <div id="grid-container">
            <table id="grid"></table>
            <div id="gridPager"></div>
        </div>
    </div>
</div>


<script>

</script>
<script>
    $(function () {
        console.log("${couponTypeList}")
        console.log("${couponTypeList}")
        var $grid = $('#grid');
        var gridPagerSelector = '#gridPager';
        var baseUrl = "/yy/manage/coupon";
        var listUrl = baseUrl + '/list';
        var canAdd = false;
        var canEdit = false;
        var canRemove = false;
        var couponType = {'f_reduce':'满减','reduce':'立减'};
        /**查询编辑任务的图表*/
        $grid.jqGrid({
            url: listUrl,
            pager: gridPagerSelector,
            colModel: [
                {
                    name: 'pin',
                    label: '站主pin',
                    width: 120,
                    editable: true,
                    editrules:{required:true}
                },
                {
                    name: 'couponId',
                    label: '优惠券编号',
                    width: 150,
                    editable: true,
                    editrules:{required:true}
                },
                {
                    name: 'couponType',
                    label: '优惠券类型',
                    width: 100,
                    editoptions:{value:couponType}
                },
                {
                    name: 'couponDesc',
                    label: '优惠券描述',
                    width: 150,
                    editable: true,
                    editrules:{required:true}
                },
                {
                    name: 'baseAmount',
                    label: '基础金额',
                    width: 100,
                    editable: true,
                    editrules:{required:true}
                },
                {
                    name: 'couponAmount',
                    label: '优惠金额(排序)',
                    width: 120,
                    editable: true,
                    editrules:{required:true},
                    sortable: true
                },
                {
                    name: 'couponNum',
                    label: '发放数量(排序)',
                    width: 120,
                    editable: true,
                    editrules:{required:true},
                    sortable: true

                },
                {
                    name: 'grantNum',
                    label: '领取数量(排序)',
                    width: 120,
                    editable: true,
                    editrules:{required:true},
                    sortable: true
                },
                {
                    name: 'usedNum',
                    label: '使用数量',
                    width: 120,
                    editable: true,
                    editrules:{required:true}
                },
                {
                    name: 'usedRate',
                    label: '使用率(%)',
                    width: 120,
                    editable: true,
                    editrules:{required:true}
                },
                {
                    name: 'startDate',
                    label: '生效日期',
                    width: 120,
                    editable: true,
                    editrules:{required:true}
                },
                {
                    name: 'endDate',
                    label: '失效日期',
                    width: 120,
                    editable: true,
                    editrules:{required:true}
                },
                {name: 'action', label: '操作', width: 80, align: 'center', viewable: false
                }
            ],
        });
        /*点击清除按钮触发该事件*/
        $('#clearBtn').click(function () {
            $('#queryPin').val('').trigger('change');
            $('#queryCouponType').val('').trigger('change');
            $('#activityValidStartDate').val('').trigger('change');
            $('#activityValidEndDate').val('').trigger('change');
            $('#activityInvalidStartDate').val('').trigger('change');
            $('#activityInvalidEndDate').val('').trigger('change');
            reloadMainGrid()
        });
        /*点击完查询触发查询事件，执行它里边重新加载表格事件*/
        $("#queryBtn").click(function () {
            reloadMainGrid()
        });
        /*选择完状态，点击查询，将根据查询条件重新加载表格*/
        function reloadMainGrid() {
            var data = {
                pin: $.trim($('#queryPin').val()),
                couponType: $.trim($('#queryCouponType').val()),
                activityValidStartDate:$.trim($('#activityValidStartDate').val()),
                activityValidEndDate:$.trim($('#activityValidEndDate').val()),
                activityInvalidStartDate:$.trim($('#activityInvalidStartDate').val()),
                activityInvalidEndDate:$.trim($('#activityInvalidEndDate').val())
            };
            reloadGrid($grid, data, true);
        }

        /*点击清除按钮触发该事件*/
        $('#clear').click(function () {
            $('#queryArea').val('').trigger('change');
            $('#queryProvince').val('').trigger('change');
            $('#queryCity').val('').trigger('change');
            $('#queryStartDate').val('').trigger('change');
            $('#queryEndDate').val('').trigger('change');
            $('#stationType').val('').trigger('change');
            reloadMainGrids()
        });
        $("#query").click(function () {
            reloadMainGrids()
        });
        /*选择完状态，点击查询，将根据查询条件重新加载表格*/
        function reloadMainGrids() {
            var data = {
                area: $.trim($('#queryArea').val()),
                province: $.trim($('#queryProvince').val()),
                city:$.trim($('#queryCity').val()),
                queryStartDate:$.trim($('#queryStartDate').val()),
                queryEndDate:$.trim($('#queryEndDate').val()),
                stationType:$.trim($('#stationType').val())
            };
            // reloadGrid($grid, data, true);
        }

        /*表格底部显现操作按钮，默认显示编辑、添加、刷新、查看, 点击编辑、添加、查下等操作按钮会弹出对话框.*/
        navGrid($grid, gridPagerSelector, {
            buttonOpts: {edit: canEdit, add: canAdd, del: canRemove, search: false, refresh: false, view: false}
        });

        $('#endDate').datetimepicker({
            language:'zh-CN',
            autoclose:1,
            todayBtn:true,
            format:'yyyy-mm-dd',
            minView:'month'
        });
        $('#startDate').datetimepicker({
            language:'zh-CN',
            autoclose:1,
            todayBtn:true,
            format:'yyyy-mm-dd',
            minView:'month'
        });
        $('#activityValidStartDate').datetimepicker({
            language:'zh-CN',
            autoclose:1,
            todayBtn:true,
            format:'yyyy-mm-dd',
            minView:'month'
        });
        $('#activityValidEndDate').datetimepicker({
            language:'zh-CN',
            autoclose:1,
            todayBtn:true,
            format:'yyyy-mm-dd',
            minView:'month'
        });
        $('#activityInvalidStartDate').datetimepicker({
            language:'zh-CN',
            autoclose:1,
            todayBtn:true,
            format:'yyyy-mm-dd',
            minView:'month'
        });
        $('#activityInvalidEndDate').datetimepicker({
            language:'zh-CN',
            autoclose:1,
            todayBtn:true,
            format:'yyyy-mm-dd',
            minView:'month'
        });

        $('#queryStartDate').datetimepicker({
            language:'zh-CN',
            autoclose:1,
            todayBtn:true,
            format:'yyyy-mm-dd',
            minView:'month'
        });

        $('#queryEndDate').datetimepicker({
            language:'zh-CN',
            autoclose:1,
            todayBtn:true,
            format:'yyyy-mm-dd',
            minView:'month'
        });

        $(function () {
            $('#areaSelect').cxSelect({
                selects: ['area', 'province', 'city'],
                jsonName: '',
                jsonValue: '',
                jsonSpace: 'data'
            });
        })

    });
</script>
</body>
</html>