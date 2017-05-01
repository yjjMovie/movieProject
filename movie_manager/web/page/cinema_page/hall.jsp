<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/04/12
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MOVIE管理系统</title>
    <script src="${pageContext.request.contextPath}/page/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/page/page_js/hall.js"></script>
</head>
<body>

<div class="container" style="width:98%">
    <h5 class="page-header">影厅管理</h5>
    <input id="addHall" type="button" class="btn btn-primary" value="添加影厅">
    <table class="table table-bordered table-hover table-condensed" id="tab">
        <tr>
            <td>编号</td>
            <td>名称</td>
            <td>行数</td>
            <td>列数</td>
            <td>座位数</td>
            <td>所属影院</td>
            <td>操作</td>
        </tr>
        <s:iterator value="#movieHallList" var="hall" status="i">
            <tr>
                <td><s:property value="#i.index+1" /></td>
                <td><s:property value="#hall.movieHallName" /></td>
                <td><s:property value="#hall.seatRow" /></td>
                <td><s:property value="#hall.seatColumn" /></td>
                <td><s:property value="#hall.seatingNum" /></td>
                <td><s:property value="#hall.cinema.cinemaName" /></td>
                <td><input  alt="<s:property value="#hall.movieHallId" />" type="button" class="btn btn-danger btn-sm" value="编辑"></td>
            </tr>
        </s:iterator>
    </table>
</div>


<!-- 添加用户对话框 -->
<div class="modal fade" id="addHallView">

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
                <h3 class="model-title">添加影厅</h3>
            </div>

            <!-- 内容主体 -->
            <div class="modal-body">
                <form id="f1">

                    <!-- 影厅名称 -->
                    <div class="form-group">
                        名称:
                        <input type="text" class="form-control" name="hall.movieHallName"/>
                    </div>

                    <!-- 影厅行数 -->
                    <div class="form-group">
                        行数:
                        <input type="text" class="form-control" name="hall.seatColumn">
                    </div>
                    <div class="form-group">
                        列数:
                        <input type="text" class="form-control" name="hall.seatRow">
                    </div>
                    <!-- 所属影院 -->
                    <div class="form-group">
                        所属影院:
                        <select class="form-control" name="cinema.cinemaId">
                            <option value="${sessionScope.cinemaManager.cinema.cinemaId}">${sessionScope.cinemaManager.cinema.cinemaName}</option>
                        </select>
                    </div>
                </form>
            </div>

            <!-- 内容尾部 -->
            <div class="modal-footer">
                <input type="button" class="btn btn-default" value="关闭" data-dismiss="modal"/>
                <input type="button" id="save" class="btn btn-primary" value="保存"/>
            </div>
        </div>
    </div>
</div>

<!-- 编辑业务人员对话框 -->
<div class="modal fade" id="updateHallView">

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
                <h3 class="model-title">编辑影厅信息</h3>
            </div>

            <!-- 内容主体 -->
            <div class="modal-body">
                <form id="f2">
                    <input type="hidden" name="hall.movieHallId" id="movieHallId" />

                    <!-- 影厅名称 -->
                    <div class="form-group">
                        名称:
                        <input type="text" class="form-control" name="hall.movieHallName" id="movieHallName"/>
                    </div>

                    <!-- 影厅行数 -->
                    <div class="form-group">
                        行数:
                        <input type="text" class="form-control" name="hall.seatColumn" id="movieHallColumn">
                    </div>
                    <div class="form-group">
                        列数:
                        <input type="text" class="form-control" name="hall.seatRow" id="movieHallRow">
                    </div>
                    <!-- 所属影院 -->
                    <div class="form-group">
                        所属影院:
                        <select class="form-control" name="cinema.cinemaId">
                            <option value="${sessionScope.cinemaManager.cinema.cinemaId}">${sessionScope.cinemaManager.cinema.cinemaName}</option>
                        </select>
                    </div>
                </form>
            </div>

            <!-- 内容尾部 -->
            <div class="modal-footer">
                <input type="button" id="update" class="btn btn-primary" value="保存"/>
                <input type="button" id="delete" class="btn btn-primary" value="删除"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>

