<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2019/9/27
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品配置</title>

    <link rel="stylesheet" type="text/css" media="screen" href="/css/common.css"/>
    <link rel="stylesheet" href="/plugins/jqGrid/css/ui.jqgrid-bootstrap.css"/>


    <script type="text/javascript" src="/plugins/jqGrid/js/jquery.jqGrid.js"></script>
    <script type="text/javascript" src="/plugins/jqGrid/js/i18n/grid.locale-cn.js"></script>
    <script type="text/javascript" src="/plugins/bootstrap-v3.3.5/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/jqGridExt.js"></script>

</head>

<body>


<table id="jqGrid"></table>
<div id="jqGridPager" class="jqgrid-pager"></div>
<script>

    $(document).ready(function () {
        //创建jqGrid组件
        $("#jqGrid").jqGrid({
            url: 'list',//组件创建完成之后请求数据的url
            datatype: "json",//请求数据返回的类型。可选json,xml,txt
            colNames: ['id', 'goodsSku', 'goodsName', 'goodsPrice', 'goodsNum', 'sellerId', 'isMarketable', 'id', 'goodsSku', 'goodsName', 'goodsPrice', 'goodsNum', 'sellerId', 'isMarketable'],//jqGrid的列显示名字
            colModel: [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
                {name: 'id', label: 'ID'},
                {name: 'goodsSku', label: 'goodsSku'},
                {name: 'goodsName', label: 'goodsName'},
                {name: 'goodsPrice', label: 'goodsPrice'},
                {name: 'goodsNum', label: 'goodsNum'},
                {name: 'sellerId', label: 'sellerId'},
                {name: 'isMarketable', label: 'isMarketable'},
                {name: 'id', label: 'ID'},
                {name: 'goodsSku', label: 'goodsSku'},
                {name: 'goodsName', label: 'goodsName'},
                {name: 'goodsPrice', label: 'goodsPrice'},
                {name: 'goodsNum', label: 'goodsNum'},
                {name: 'sellerId', label: 'sellerId'},
                {name: 'isMarketable', label: 'isMarketable'}
            ],
            rowNum: 10,//一页显示多少条
            rowList: [10, 20, 30],//可供用户选择一页显示多少条
            pager: '#jqGridPager',//表格页脚的占位符(一般是div)的id
            emptyrecords: "Nothing to display",

            /*  sortname: 'id',//初始化的时候排序的字段*/
            /*sortorder: "desc",//排序方式,可选desc,asc*/
            mtype: "get",//向后台请求数据的ajax的类型。可选post,get
            autowidth: true,
            shrinkToFit: false,
            viewrecords:true//显示第1到第10条　共 22 条
            /* viewrecords: true,
             caption: "JSON Example"//表格的标题名字*/
        })
    });

</script>
</body>
</html>
