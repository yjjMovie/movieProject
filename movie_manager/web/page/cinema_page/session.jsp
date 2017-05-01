<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/04/12
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>MOVIE管理系统</title>

    <script src="${pageContext.request.contextPath}/page/js/jquery-1.9.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/page/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/page/page_js/session.js"></script>
</head>

<body>

<div class="container" style="width:98%;">
    <h5 class="page-header">场次管理</h5>
    <input id="addSession" type="button" class="btn btn-primary" value="添加场次">
    <table class="table table-bordered table-hover table-condensed" id="tab">
        <tr>
            <td>编号</td>
            <td>所播电影</td>
            <td>播放时间</td>
            <td>结束时间</td>
            <td>所属影院</td>
            <td>所属影厅</td>
            <td>价格</td>
            <td>操作</td>
        </tr>
        <s:iterator value="#sessionList" var="session" status="i">
            <tr>
                <td><s:property value="#i.index+1" /></td>
                <td><s:property value="#session.movie.movieName" /></td>
                <td><s:date name="#session.startTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                <td><s:date name="#session.endTime" format="yyyy-MM-dd HH:mm:ss" /></td>
                <td><s:property value="#session.cinema.cinemaName" /></td>
                <td><s:property value="#session.movieHall.movieHallName" /></td>
                <td><s:property value="#session.sessionPrice" /></td>
                <td><input  alt="<s:property value="#session.sessionId" />" type="button" class="btn btn-danger btn-sm" value="编辑"></td>
            </tr>
        </s:iterator>
    </table>
</div>

<!-- 添加场次信息 -->
<div class="modal hide fade" id="addSessionView">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- 内容头部 -->
            <div class="modal-header">
                <!-- 关闭按钮 -->
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <!-- 标题 -->
                <h3 class="model-title">添加场次信息</h3>
            </div>

            <div class="modal-body">
                <form id="f1" enctype="multipart/form-data">
                    <!-- 所属影院 -->
                    <div class="form-group">
                        所属影院:
                        <select name="cinema.cinemaId" class="form-control" id="cinemaName">
                            <option value="${sessionScope.cinemaManager.cinema.cinemaId}">${sessionScope.cinemaManager.cinema.cinemaName}</option>
                        </select>
                    </div>
                    <!-- 所属影厅 -->
                    <div class="form-group">
                        所属影厅:
                        <select name="movieHall.movieHallId" class="form-control" id="hallName">
                        </select>
                    </div>
                    <!-- 所播电影-->
                    <div class="form-group">
                        所播电影:
                        <select name="movie.movieId" class="form-control" id="movieName">
                        </select>
                    </div>
                    <!-- 播放时间 -->
                    <div class="form-group">
                        播放时间:
                        <input type="text" name="movieSession.startTime" class="form-control" />
                    </div>
                    <!-- 结束时间 -->
                    <div class="form-group">
                        结束时间:
                        <input type="text" name="movieSession.endTime" class="form-control" />
                    </div>
                    <!-- 价格 -->
                    <div class="form-group">
                        价格:
                        <input type="text" name="movieSession.sessionPrice" class="form-control" />
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

<!-- 编辑电影信息对话框 -->
<div class="modal hide fade" id="updateSessionView">

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
                <h3 class="model-title">编辑电影信息</h3>
            </div>

            <!-- 内容主体 -->
            <div class="modal-body">
                <s:fielderror cssStyle="color:red" />
                <form id="f2">
                    <input type="hidden" name="movieSession.sessionId" id="sessionId" />


                    <!-- 所属影院 -->
                    <div class="form-group">
                        所属影院:
                        <select name="cinema.cinemaId" class="form-control" id="cinema">
                            <option value="${sessionScope.cinemaManager.cinema.cinemaId}">${sessionScope.cinemaManager.cinema.cinemaName}</option>
                        </select>
                    </div>
                    <!-- 所属影厅 -->
                    <div class="form-group">
                        所属影厅:
                        <select name="movieHall.movieHallId" class="form-control" id="hall">
                        </select>
                    </div>
                    <!-- 所播电影-->
                    <div class="form-group">
                        所播电影:
                        <select name="movie.movieId" class="form-control" id="movie">
                        </select>
                    </div>
                    <!-- 播放时间 -->
                    <div class="form-group">
                        播放时间:
                        <input type="text" class="form-control" name="movieSession.startTime" id="startTime" />
                    </div>
                    <!-- 结束时间 -->
                    <div class="form-group">
                        结束时间:
                        <input type="text" class="form-control" name="movieSession.endTime" id="endTime" />
                    </div>
                    <!-- 价格 -->
                    <div class="form-group">
                        价格:
                        <input type="text" class="form-control" name="movieSession.sessionPrice" id="sessionPrice" />
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
