<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/04/11
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>MOVIE管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/page/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
    <script src="../page_js/cinema.js"></script>
    <style>
        textarea {
            resize: none;
            width: 300px;
        }
    </style>
</head>
<body>

<div class="container" style="width:98%">
    <h5 class="page-header">影院管理</h5>
    <table class="table table-bordered table-hover table-condensed" id="tab">
        <tr>
            <td>名称</td>
            <td>地址</td>
            <td>所属区域</td>
            <td>电话</td>
            <td>操作</td>
        </tr>
        <tr>
            <td>${sessionScope.cinema.cinemaName}</td>
            <td>${sessionScope.cinema.cinemaAddr}</td>
            <td>${sessionScope.cinema.area.areaName}</td>
            <td>${sessionScope.cinema.cinemaTel}</td>
            <td><input  alt="${sessionScope.cinema.cinemaId}" type="button" class="btn btn-danger btn-sm" value="编辑"></td>
        </tr>
    </table>
</div>



<!-- 编辑影院信息对话框 -->
<div class="modal fade" id="updateCinemaView">

    <!-- 模式对话框的主体，包括一些遮罩层样式 -->
    <div class="modal-dialog">


        <!-- 这个div将涵盖对话框的内容，内容分为三部分，内容头部、内容主体、内容尾部 -->
        <div class="modal-content">
            <!-- 内容头部 -->
            <div class="modal-header">
                <!-- 关闭按钮 -->
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <!-- 标题 -->
                <h3 class="model-title">编辑影院信息</h3>
            </div>

            <!-- 内容主体 -->
            <div class="modal-body">
                <form id="f2">
                    <input type="hidden" name="cinema.cinemaId" id="cinemaId" />


                    <!-- 影院名称 -->
                    <div class="form-group">
                        名称:
                        <input type="text" class="form-control" name="cinema.cinemaName" id="cinemaName"/>
                    </div>

                    <!-- 影院地址-->
                    <div class="form-group">
                        地址:
                        <textarea rows="3" class="form-control" name="cinema.cinemaAddr"name="" id="cinemaAddr"></textarea>
                    </div>
                    <!-- 影院电话 -->
                    <div class="form-group">
                        电话:
                        <input type="text" class="form-control" name="cinema.cinemaTel" id="cinemaTel">
                    </div>
                    <!-- 影院所属区域 -->
                    <div class="form-group">
                        所属区域:
                        <select class="form-control" name="area.areaId" id="areaName">
                        </select>
                    </div>
                </form>
            </div>

            <!-- 内容尾部 -->
            <div class="modal-footer">
                <input type="button" id="save" class="btn btn-primary" value="保存"/>
                <input type="button" class="btn btn-default" value="关闭" data-dismiss="modal"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>

