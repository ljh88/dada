<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2019/11/4
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<html>
<head>
    <title><decorator:title default="运营后台"/></title>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="/plugins/bootstrap-v3.3.5/css/bootstrap.css">
    <link rel="stylesheet" href="/css/style.css">
    <link href="/plugins/select2/select2.min.css" rel="stylesheet" type="text/css">

    <script src="/plugins/jquery.min.js" type="text/javascript"></script>
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
        </div>

        <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <div class="navbar-sideholder"></div>
            <ul class="nav navbar-nav side-nav" id="side-menu">
                <li class="sidebar-search" style="float: none;">
                    <div class="custom-search-form">
                        <select id="side-search" class="form-control">
                            <option id="default-search" selected="selected"></option>
                        </select>
                    </div>
                    <!-- /input-group -->
                </li>
                <li class="active">
                    <a href="#"><i class="fa fa-edit fa-fw"></i>人员管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="/yy/manage/areaContactManagement" data-menu="p_area_manager">区域负责人管理</a></li>
                    </ul>
                </li>
                <li class="active">
                    <a href="#"><i class="fa fa-edit fa-fw"></i>用户管理<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a href="/yy/manage/businessLicense" data-menu="c_user">营业执照号查询</a></li>
                    </ul>
                </li>
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

</div>

</body>
</html>
