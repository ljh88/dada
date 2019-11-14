<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2019/11/7
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/ecmascript" src="/plugins/jqGrid/js/i18n/grid.locale-cn.js"></script>
    <script type="text/ecmascript" src="/plugins/jqGrid/js/jquery.jqGrid.min.js"></script>

    <link rel="stylesheet" type="text/css" media="screen" href="/css/common.css" />

    <meta charset="utf-8" />
    <title>jqGrid Loading Data - Million Rows from a REST service</title>
</head>
<body class="gray-bg">

<table id="jqGrid"></table>
<div id="jqGridPager"></div>

<%--
<div id="jqGridPager"  class="select-table table-striped"></div>
--%>

<script type="text/javascript">
    $(document).ready(function () {
        $("#jqGrid").jqGrid({
            url: 'http://trirand.com/blog/phpjqgrid/examples/jsonp/getjsonp.php?callback=?&qwery=longorders',
            mtype: "GET",
            datatype: "jsonp",
            colModel: [
                { label: 'OrderID', name: 'OrderID', key: true},
                { label: 'Customer ID', name: 'CustomerID'},
                { label: 'Order Date', name: 'OrderDate',
                    formatter : 'date', formatoptions: { srcformat : 'Y-m-d H:i:s', newformat :'ShortDate'}},
                { label: 'Freight', name: 'Freight'},
                { label:'Ship Name', name: 'ShipName'}
            ],
            viewrecords: true,
            height: true,
            rowNum: 10,
            autowidth: true,
            pager: "#jqGridPager"
        });
    });

</script>


</body>
</html>
